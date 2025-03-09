import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][2];
        StringTokenizer st;
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n + 1][100];
        for (int i = 1; i < n + 1; i++) {
            int cost = arr[i][0];
            int value = arr[i][1];
            for (int j = 0; j < 100; j++) {
                if (cost > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost] + value);
                }
            }
        }

        System.out.println(dp[n][99]);
    }
}