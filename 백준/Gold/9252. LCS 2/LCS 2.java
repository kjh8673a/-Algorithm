import java.io.*;

public class Main {
    static char[] a, b, result;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine().toCharArray();
        b = br.readLine().toCharArray();

        dp = new int[a.length + 1][b.length + 1];
        for (int i = 1; i < a.length + 1; i++) {
            for (int j = 1; j < b.length + 1; j++) {
                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dp[a.length][b.length]).append("\n");

        result = new char[dp[a.length][b.length]];
        findResult(a.length, b.length, 0);
        for (int i = result.length - 1; i >= 0; i--) {
            sb.append(result[i]);
        }

        System.out.println(sb);
    }

    private static void findResult(int r, int c, int idx) {
        if (idx == dp[a.length][b.length]) {
            return;
        }

        if (dp[r][c] == dp[r - 1][c]) {
            findResult(r - 1, c, idx);
        } else if (dp[r][c] == dp[r][c - 1]) {
            findResult(r, c - 1, idx);
        } else {
            result[idx] = a[r - 1];
            findResult(r - 1, c - 1, idx + 1);
        }
    }

}
