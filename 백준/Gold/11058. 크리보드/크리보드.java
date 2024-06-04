import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n + 1];

        for (int i = 1; i < n + 1; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i > 6) {
                for (int j = 3; j <= 5; j++) {
                    dp[i] = Math.max(dp[i - j] * (j - 1), dp[i]);
                }
            }
        }

        System.out.println(dp[n]);
    }

}