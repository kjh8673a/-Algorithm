import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] dp = new int[k + 2][n + 1];
            Arrays.fill(dp[0], 1);
            for (int i = 1; i < k + 2; i++) {
                for (int j = 1; j < n + 1; j++) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }

            sb.append(dp[k + 1][n]).append("\n");
        }

        System.out.println(sb.toString());
    }

}
