import java.io.*;

public class Main {
    static final long mod = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int d = Integer.parseInt(br.readLine());

        long[][] dp = new long[d + 1][8];
        dp[0][0] = 1;
        /*
         * 0 - 정보과학관
         * 1 - 전산관
         * 2 - 미래관
         * 3 - 신양관
         * 4 - 진리관
         * 5 - 한경직기념관
         * 6 - 학생회관
         * 7 - 형남공학관
         */

        for (int i = 1; i < d + 1; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2] + dp[i - 1][3]) % mod;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][3] + dp[i - 1][5]) % mod;
            dp[i][3] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4] + dp[i - 1][5]) % mod;
            dp[i][4] = (dp[i - 1][3] + dp[i - 1][5] + dp[i - 1][6]) % mod;
            dp[i][5] = (dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4] + dp[i - 1][7]) % mod;
            dp[i][6] = (dp[i - 1][4] + dp[i - 1][7]) % mod;
            dp[i][7] = (dp[i - 1][5] + dp[i - 1][6]) % mod;
        }

        System.out.println(dp[d][0]);
    }
}