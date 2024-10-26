import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] weight;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        weight = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        dp = new boolean[n + 1][40001];
        doDp(0, 0);

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int marble = Integer.parseInt(st.nextToken());
            if (dp[n][marble]) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }
        }

        System.out.println(sb);
    }

    private static void doDp(int cnt, int sum) {
        if (sum > 500 * 30 || dp[cnt][sum]) {
            return;
        }
        dp[cnt][sum] = true;

        if (cnt == n) {
            return;
        }

        doDp(cnt + 1, sum + weight[cnt]);
        doDp(cnt + 1, sum);
        doDp(cnt + 1, Math.abs(sum - weight[cnt]));
    }

}