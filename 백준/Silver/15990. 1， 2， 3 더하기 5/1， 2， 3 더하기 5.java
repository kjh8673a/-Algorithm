import java.io.*;

public class Main {
    static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[][] dp = new long[100001][4];
        dp[1][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;
        int last = 3;

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            if (n > last) {
                for (int j = last + 1; j <= n; j++) {
                    dp[j][1] = (dp[j - 1][2] + dp[j - 1][3]) % MOD;
                    dp[j][2] = (dp[j - 2][1] + dp[j - 2][3]) % MOD;
                    dp[j][3] = (dp[j - 3][1] + dp[j - 3][2]) % MOD;
                }
                last = n;
            }

            sb.append((dp[n][1] + dp[n][2] + dp[n][3]) % MOD).append("\n");
        }

        System.out.println(sb);
    }
}