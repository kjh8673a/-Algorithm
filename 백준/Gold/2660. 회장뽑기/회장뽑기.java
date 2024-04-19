import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] relation = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (i == j) {
                    relation[i][j] = 0;
                } else {
                    relation[i][j] = 100000000;
                }
            }
        }

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) {
                break;
            }

            relation[a][b] = 1;
            relation[b][a] = 1;
        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    relation[i][j] = Math.min(relation[i][j], relation[i][k] + relation[k][j]);
                }
            }
        }

        int cnt = 0;
        int win = Integer.MAX_VALUE;
        int[] score = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            boolean flag = true;
            int max = 0;
            for (int j = 1; j < n + 1; j++) {
                if (relation[i][j] < 100000000) {
                    max = Math.max(relation[i][j], max);
                }
            }
            if (flag) {
                if (win == max) {
                    cnt++;
                } else if (win > max) {
                    win = max;
                    cnt = 1;
                }
                score[i] = max;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(win + " " + cnt).append("\n");
        for (int i = 1; i < n + 1; i++) {
            if (score[i] == win) {
                sb.append(i + " ");
            }
        }

        System.out.println(sb);
    }

}