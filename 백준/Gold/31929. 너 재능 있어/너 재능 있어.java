import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] win = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            win[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] lose = new int[m + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < m + 1; i++) {
            lose[i] = Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine());

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = dp[i - 1][0] + win[i];
        }
        for (int j = 1; j < m + 1; j++) {
            if (Math.floorMod(dp[0][j - 1], k) == 0) {
                dp[0][j] = dp[0][j - 1] - lose[j];
            } else {
                dp[0][j] = dp[0][j - 1] - Math.min(Math.floorMod(dp[0][j - 1], k), lose[j]);

            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (Math.floorMod(dp[i][j - 1], k) == 0) {
                    dp[i][j] = Math.max(dp[i - 1][j] + win[i], dp[i][j - 1] - lose[j]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j] + win[i],
                            dp[i][j - 1] - Math.min(Math.floorMod(dp[i][j - 1], k), lose[j]));
                }
            }
        }

        System.out.println(dp[n][m]);
    }

}