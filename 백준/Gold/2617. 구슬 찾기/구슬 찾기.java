import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] list = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a][b] = 1;
            list[b][a] = -1;
        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (list[i][k] == 1 && list[k][j] == 1) {
                        list[i][j] = 1;
                    }
                    if (list[i][k] == -1 && list[k][j] == -1) {
                        list[i][j] = -1;
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i < n + 1; i++) {
            int up = 0;
            int down = 0;
            for (int j = 1; j < n + 1; j++) {
                if (list[i][j] == 1) {
                    up++;
                }
                if (list[i][j] == -1) {
                    down++;
                }
            }
            if (up > n / 2 || down > n / 2) {
                answer++;
            }
        }

        System.out.println(answer);
    }

}