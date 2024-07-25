import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int answer = 0;
            int[][] block = new int[r][c];
            for (int i = 0; i < r; i++) {
                String line = br.readLine();
                for (int j = 0; j < c; j++) {
                    block[i][j] = line.charAt(j) - '0';
                    if (block[i][j] > 0) {
                        answer++;
                    }
                }
            }
            answer *= 2;

            for (int i = 0; i < r; i++) {
                int prev = 0;
                for (int j = 0; j < c; j++) {
                    if (block[i][j] > prev) {
                        answer += block[i][j] - prev;
                    }
                    prev = block[i][j];
                }

                prev = 0;
                for (int j = c - 1; j >= 0; j--) {
                    if (block[i][j] > prev) {
                        answer += block[i][j] - prev;
                    }
                    prev = block[i][j];
                }
            }

            for (int i = 0; i < c; i++) {
                int prev = 0;
                for (int j = 0; j < r; j++) {
                    if (block[j][i] > prev) {
                        answer += block[j][i] - prev;
                    }
                    prev = block[j][i];
                }

                prev = 0;
                for (int j = r - 1; j >= 0; j--) {
                    if (block[j][i] > prev) {
                        answer += block[j][i] - prev;
                    }
                    prev = block[j][i];
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

}