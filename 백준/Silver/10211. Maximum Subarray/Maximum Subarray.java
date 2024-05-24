import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[n];
            dp[0] = arr[0];

            int answer = dp[0];
            for (int i = 1; i < n; i++) {
                dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
                answer = Math.max(answer, dp[i]);
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}