import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] apps = new int[n + 1][2];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                apps[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n + 1][10001];
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            int memory = apps[i][0];
            int cost = apps[i][1];
            for (int j = 0; j < 10001; j++) {
                if (cost > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost] + memory);
                }

                if (dp[i][j] >= m) {
                    answer = Math.min(answer, j);
                }
            }
        }

        System.out.println(answer);
    }
}