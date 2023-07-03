import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static long[][] dp;

    final static long MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        dp = new long[N + 1][M + 1];
        for(int i = 0; i < N + 1; i++) {
            for(int j = 0; j < M + 1; j++) {
                dp[i][j] = -1;
            }
        }
        dp[1][1] = 1;

        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            dp[x][y] = 0;
        }

        System.out.println(doDp(N, M));

    }

    private static long doDp(int r, int c) {
        if(r < 1 || c < 1 || r > N || c > M) {
            return 0;
        }

        if(dp[r][c] != -1) {
            return dp[r][c];
        }

        if(c % 2 == 0) {
            return dp[r][c] = (doDp(r + 1, c - 1) + doDp(r, c - 1) + doDp(r - 1, c)) % MOD;
        }else {
            return dp[r][c] = (doDp(r, c - 1) + doDp(r - 1, c - 1) + doDp(r - 1, c)) % MOD;
        }
    }

}
