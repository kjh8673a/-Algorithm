import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            dp[i] = 10001;

            for (int j = 0; j < n; j++) {
                if (i - coin[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin[j]] + 1);
                }
            }
        }

        System.out.println(dp[k] == 10001 ? -1 : dp[k]);
    }

}