import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if (k > 0) {
            int nr = (k - 1) / m;
            int nc = (k - 1) % m;
            System.out.println(doDp(nr + 1, nc + 1) * doDp(n - nr, m - nc));

        } else {
            System.out.println(doDp(n, m));
        }
    }

    private static int doDp(int r, int c) {
        int[][] dp = new int[r + 1][c + 1];
        dp[0][1] = 1;
        for (int i = 1; i < r + 1; i++) {
            for (int j = 1; j < c + 1; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[r][c];
    }

}