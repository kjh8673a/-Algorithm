import java.io.*;

public class Main {
    static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[50_001];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;

        for (int i = 4; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 3]) % MOD;
        }

        System.out.println(dp[n]);
    }

}