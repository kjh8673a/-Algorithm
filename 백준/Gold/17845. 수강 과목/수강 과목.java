import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] subjects = new int[k + 1][2];
        for (int i = 1; i < k + 1; i++) {
            st = new StringTokenizer(br.readLine());
            subjects[i][0] = Integer.parseInt(st.nextToken());
            subjects[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[k + 1][n + 1];
        for (int i = 1; i < k + 1; i++) {
            int cost = subjects[i][1];
            int value = subjects[i][0];
            for (int j = 1; j < n + 1; j++) {
                if (cost > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost] + value);
                }
            }
        }

        System.out.println(dp[k][n]);
    }
}