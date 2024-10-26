import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken().replace(".", ""));

            if (n == 0 && m == 0) {
                break;
            }

            int[][] candies = new int[n + 1][2];
            for (int i = 1; i < n + 1; i++) {
                st = new StringTokenizer(br.readLine());
                candies[i][0] = Integer.parseInt(st.nextToken());
                candies[i][1] = Integer.parseInt(st.nextToken().replace(".", ""));
            }

            int[][] dp = new int[n + 1][m + 1];
            for (int i = 1; i < n + 1; i++) {
                int calorie = candies[i][0];
                int price = candies[i][1];

                for (int j = 0; j < m + 1; j++) {
                    if (price <= j) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - price] + calorie);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            sb.append(dp[n][m]).append("\n");
        }

        System.out.println(sb);
    }

}