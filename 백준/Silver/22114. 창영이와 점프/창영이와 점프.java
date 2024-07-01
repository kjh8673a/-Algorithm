import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int[][] dp = new int[n][2];
        dp[0][0] = dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > k) {
                dp[i][1] = dp[i - 1][0] + 1;
                dp[i][0] = 1;
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1] + 1;
            }

            answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.println(answer);
    }

}