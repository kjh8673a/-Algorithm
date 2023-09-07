import java.util.*;
import java.io.*;

public class Main {
    static int n, k;
    static int[] arr;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            if (n == 0 && k == 0) {
                break;
            }

            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dp = new long[n][k + 1];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1);
                dp[i][1] = 1;
            }

            long ans = 0;
            for (int i = 0; i < n; i++) {
                ans += solve(i, k);
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }

    private static long solve(int idx, int len) {
        if (dp[idx][len] != -1) {
            return dp[idx][len];
        }

        long tmp = 0;
        for (int i = idx + 1; i < n; i++) {
            if (arr[i] > arr[idx]) {
                tmp += solve(i, len - 1);
            }
        }

        return dp[idx][len] = tmp;
    }

}
