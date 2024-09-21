import java.io.*;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n + 1][5];
        dp[1][0] = dp[1][1] = dp[1][2] = dp[1][3] = dp[1][4] = 1;

        for (int i = 2; i < n + 1; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][3] + dp[i - 1][4]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][4]) % MOD;
            dp[i][3] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
            dp[i][4] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
        }

        long answer = 0;
        for (int i = 0; i < 5; i++) {
            answer = (answer + dp[n][i]) % MOD;
        }

        System.out.println(answer);
    }

}