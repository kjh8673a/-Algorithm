import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[N][2];
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        for (int i = 1; i < N; i++) {
            dp[i][0] = Math.min(dp[i - 1][0] + arr[i][0], dp[i - 1][1] + K + arr[i][0]);
            dp[i][1] = Math.min(dp[i - 1][1] + arr[i][1], dp[i - 1][0] + K + arr[i][1]);
        }

        System.out.println(dp[N - 1][0] < dp[N - 1][1] ? dp[N - 1][0] : dp[N - 1][1]);
    }

}
