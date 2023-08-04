import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            int K = Integer.parseInt(br.readLine());

            int[] sum = new int[K + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i < K + 1; i++) {
                sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[K + 1][K + 1];
            for (int gap = 1; gap < K; gap++) {
                for (int i = 1; i <= K - gap; i++) {
                    int j = i + gap;
                    dp[i][j] = Integer.MAX_VALUE;

                    for (int d = i; d < j; d++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][d] + dp[d + 1][j] + sum[j] - sum[i - 1]);
                    }
                }
            }

            sb.append(dp[1][K]).append("\n");
        }

        System.out.println(sb);
    }

}