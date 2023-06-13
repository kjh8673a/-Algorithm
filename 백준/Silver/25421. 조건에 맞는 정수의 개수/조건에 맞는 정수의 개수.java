import java.io.*;

public class Main {
    private static final int MOD = 987_654_321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());

        int[][] dp = new int[A + 1][10];
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= A; i++) {
            for (int j = 1; j < 10; j++) {
                int tmp = 0;
                for (int k = j - 2; k <= j + 2; k++) {
                    if (k >= 1 && k <= 9) {
                        tmp = sum(tmp, dp[i - 1][k]);
                    }
                }
                dp[i][j] = tmp;
            }
        }

        int ans = 0;
        for (int i = 1; i < 10; i++) {
            ans = sum(ans, dp[A][i]);
        }

        System.out.println(ans);
    }

    private static int sum(int a, int b) {
        return (a + b) % MOD;
    }

}
