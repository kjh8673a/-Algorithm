import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[][] dp = new int[M + 1][K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[1][arr[i] % K] = Math.max(dp[1][arr[i] % K], arr[i]);
        }

        for (int i = 2; i < M + 1; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < K; k++) {
                    if (dp[i - 1][Math.floorMod(k - arr[j], K)] != 0) {
                        dp[i][k] = Math.max(dp[i][k], dp[i - 1][Math.floorMod(k - arr[j], K)] + arr[j]);
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 1; i < M + 1; i++) {
            ans = Math.max(dp[i][0], ans);
        }

        System.out.println(ans);
    }

}
