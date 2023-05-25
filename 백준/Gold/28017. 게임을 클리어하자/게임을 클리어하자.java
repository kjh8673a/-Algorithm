import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N][M];
        for (int i = 0; i < 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < M; k++) {
                    if (k == j) {
                        continue;
                    }
                    min = Math.min(min, dp[i - 1][k]);
                }
                dp[i][j] += min;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            ans = Math.min(ans, dp[N - 1][i]);
        }

        System.out.println(ans);

    }

}