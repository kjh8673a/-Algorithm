import java.io.*;

public class Main {
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        dp = new int[41][2];
        dp[0][0] = 1;
        dp[1][1] = 1;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            fibonacci(n);

            sb.append(dp[n][0] + " " + dp[n][1]).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int[] fibonacci(int n) {
        if (dp[n][0] == 0 && dp[n][1] == 0) {
            dp[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
            dp[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
        }
        return dp[n];
    }

}