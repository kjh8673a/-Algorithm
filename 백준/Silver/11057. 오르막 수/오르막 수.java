import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][11];
        for (int i = 1; i <= 10; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j <= 10; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 10007;
            }
        }

        System.out.println(dp[N][10]);
    }
}