import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken()); // 자두가 떨어지는 시간
        int W = Integer.parseInt(st.nextToken()); // 최대 움직이는 횟수

        // [시간][나무 번호][이동 횟수]
        int[][][] dp = new int[T + 1][3][W + 2];

        for (int i = 1; i <= T; i++) {
            int a = Integer.parseInt(br.readLine());
            for (int j = 1; j <= W + 1; j++) {
                if (a == 1) {
                    dp[i][1][j] = Math.max(dp[i - 1][1][j] + 1, dp[i - 1][2][j - 1] + 1);
                    dp[i][2][j] = Math.max(dp[i - 1][1][j - 1], dp[i - 1][2][j]);
                } else {
                    if(i == 1 && j == 1) {
                        continue;
                    }
                    dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][2][j - 1]);
                    dp[i][2][j] = Math.max(dp[i - 1][1][j - 1] + 1, dp[i - 1][2][j] + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= W + 1; i++) {
            ans = Math.max(ans, Math.max(dp[T][1][i], dp[T][2][i]));
        }

        System.out.println(ans);
    }

}