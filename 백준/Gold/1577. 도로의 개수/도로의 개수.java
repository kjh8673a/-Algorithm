import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[][] dp = new long[n + 1][m + 1];
        int[][][] block = new int[n + 1][m + 1][2];

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (b == d) {
                block[Math.min(a, c)][b][0] = 1;
            } else {
                block[a][Math.min(b, d)][1] = 1;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            if (block[i - 1][0][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }

        for (int i = 1; i < m + 1; i++) {
            if (block[0][i - 1][1] == 1) {
                break;
            }
            dp[0][i] = 1;
        }

        dp[0][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                dp[i][j] = 0;
                if (block[i - 1][j][0] != 1) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (block[i][j - 1][1] != 1) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }

        System.out.println(dp[n][m]);
    }

}