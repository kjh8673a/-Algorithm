import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            int[][] dp = new int[n][3];

            StringTokenizer st;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    dp[i][j] = Integer.parseInt(st.nextToken());
                    if (i == 1) {
                        if (j == 0) {
                            dp[i][j] += dp[0][1];
                        } else if (j == 1) {
                            dp[i][j] += Math.min(dp[i][j - 1], Math.min(dp[0][1], dp[0][1] + dp[0][2]));
                        } else {
                            dp[i][j] += Math.min(dp[i][j - 1], Math.min(dp[0][1], dp[0][1] + dp[0][2]));
                        }
                    } else if (i > 1) {
                        if (j == 0) {
                            dp[i][j] += Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                        } else if (j == 1) {
                            dp[i][j] += Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]),
                                    Math.min(dp[i - 1][j], dp[i - 1][j + 1]));
                        } else {
                            dp[i][j] += Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]);
                        }
                    }
                }
            }
            sb.append(tc++).append(". ").append(dp[n - 1][1]).append("\n");
        }

        System.out.println(sb);
    }

}