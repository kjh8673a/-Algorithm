import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] memory = new int[n + 1];
        int[] cost = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            sum += cost[i];
        }

        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 1; i < n + 1; i++) {

            for (int j = 0; j < sum + 1; j++) {
                if (cost[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost[i]] + memory[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < sum + 1; i++) {
            if (dp[n][i] >= m) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }

}