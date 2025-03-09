import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] subjects = new int[n + 1][2];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            subjects[i][0] = Integer.parseInt(st.nextToken());
            subjects[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n + 1][t + 1];
        for (int i = 1; i < n + 1; i++) {
            int time = subjects[i][0];
            int score = subjects[i][1];
            for (int j = 1; j < t + 1; j++) {
                if (time > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - time] + score);
                }
            }
        }

        System.out.println(dp[n][t]);
    }
}