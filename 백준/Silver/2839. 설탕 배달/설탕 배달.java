import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];
        if (n >= 3) {
            dp[3] = 1;
        }
        if (n >= 5) {
            dp[5] = 1;
        }

        for (int i = 6; i <= n; i++) {
            if (dp[i - 5] != 0 && dp[i - 3] != 0) {
                dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
            } else if (dp[i - 5] != 0) {
                dp[i] = dp[i - 5] + 1;
            } else if (dp[i - 3] != 0) {
                dp[i] = dp[i - 3] + 1;
            }
        }

        System.out.println(dp[n] == 0 ? -1 : dp[n]);
    }
}