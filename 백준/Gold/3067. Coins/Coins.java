import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());

            int[] coins = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n + 1; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(br.readLine());

            int[][] dp = new int[n + 1][m + 1];

            for (int i = 1; i < n + 1; i++) {
                dp[i][0] = 1;
                for (int j = 1; j < m + 1; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (coins[i] <= j) {
                        dp[i][j] += dp[i][j - coins[i]];
                    }
                }
            }

            sb.append(dp[n][m]).append("\n");
        }

        System.out.println(sb);
    }

}