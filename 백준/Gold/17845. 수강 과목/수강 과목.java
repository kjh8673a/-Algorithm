import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] subject = new int[k + 1][2];

        for (int i = 1; i < k + 1; i++) {
            st = new StringTokenizer(br.readLine());
            subject[i][0] = Integer.parseInt(st.nextToken());
            subject[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[k + 1][n + 1];
        for (int i = 1; i < k + 1; i++) {
            int importance = subject[i][0];
            int time = subject[i][1];

            for (int j = 1; j < n + 1; j++) {
                if (time <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - time] + importance);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[k][n]);
    }

}