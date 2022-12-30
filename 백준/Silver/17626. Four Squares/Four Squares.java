import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            int a = 1;
            while (i + a * a <= n) {
                dp[i + a * a] = (dp[i + a * a] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i + a * a]);
                a++;
            }
        }

        System.out.println(dp[n]);
    }
}