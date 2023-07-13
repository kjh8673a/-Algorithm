import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] forest, dp;

    static int[][] vector = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        forest = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(dfs(i, j), ans);
            }
        }

        System.out.println(ans);
    }

    private static int dfs(int r, int c) {
        if (dp[r][c] > 0) {
            return dp[r][c];
        }

        dp[r][c] = 1;
        for (int i = 0; i < 4; i++) {
            int nr = r + vector[i][0];
            int nc = c + vector[i][1];

            if (nr < 0 || nc < 0 || nr >= n || nc >= n) {
                continue;
            }

            if (forest[r][c] < forest[nr][nc]) {
                dp[r][c] = Math.max(dfs(nr, nc) + 1, dp[r][c]);
            }
        }

        return dp[r][c];
    }

}
