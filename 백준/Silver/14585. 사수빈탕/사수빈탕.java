import java.io.*;
import java.util.*;

public class Main {
    static int[][] vector = { { 1, 0 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int r = 0;
        int c = 0;
        boolean[][] candies = new boolean[302][302];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            candies[x + 1][y + 1] = true;
            r = Math.max(r, x + 1);
            c = Math.max(c, y + 1);
        }

        int[][] dp = new int[r + 1][c + 1];
        for (int i = 1; i < r + 1; i++) {
            for (int j = 1; j < c + 1; j++) {
                if (candies[i][j]) {
                    int candy = Math.max(0, m - (i + j) + 2);
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + candy;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[r][c]);
    }
}