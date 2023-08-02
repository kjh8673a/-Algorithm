import java.io.*;

public class Main {
    private static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < N + 1; i++) {
            dp[i] = (dp[i - 2] + dp[i / 2]) % MOD;
        }

        System.out.println(dp[N]);
    }
}