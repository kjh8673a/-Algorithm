import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int burgers = Integer.parseInt(st.nextToken());
        int fries = Integer.parseInt(st.nextToken());

        int[][] order = new int[n + 1][2];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            order[i][0] = Integer.parseInt(st.nextToken());
            order[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][][] dp = new int[n + 1][burgers + 1][fries + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < burgers + 1; j++) {
                for (int k = 1; k < fries + 1; k++) {
                    if (order[i][0] > j || order[i][1] > k) {
                        dp[i][j][k] = dp[i - 1][j][k];
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - order[i][0]][k - order[i][1]] + 1);
                    }
                }
            }
        }

        System.out.println(dp[n][burgers][fries]);
    }

}