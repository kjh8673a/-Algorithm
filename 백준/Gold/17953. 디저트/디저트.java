import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dessert = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                dessert[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                for (int k = 1; k < m + 1; k++) {
                    if (i != 1 && k == j) {
                        dp[i][j] = Math.max(dp[i - 1][k] + dessert[j][i] / 2, dp[i][j]);
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][k] + dessert[j][i], dp[i][j]);
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 1; i < m + 1; i++) {
            answer = Math.max(dp[n][i], answer);
        }

        System.out.println(answer);
    }
}