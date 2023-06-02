import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dp = new int[N + 1];
        dp[0] = 1;

        for (int i = 1; i < N + 1; i++) {
            dp[i] += dp[i - 1];
            if (i >= M) {
                dp[i] += dp[i - M];
            }
            dp[i] %= MOD;
        }

        System.out.println(dp[N]);
    }

}