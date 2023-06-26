import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 지폐의 금액
        int K = Integer.parseInt(br.readLine()); // 동전의 가지 수
        int[][] coins = new int[K][2];
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            coins[i][0] = Integer.parseInt(st.nextToken()); // 동전 하나의 금액
            coins[i][1] = Integer.parseInt(st.nextToken()); // 개수
        }

        int[][] dp = new int[T + 1][K + 1]; // dp[t][k] => 금액 t에 대해 동전 k개 까지 썼을 때 개수를 저장

        for (int i = 0; i < K; i++) {
            dp[0][i] = 1; // 금액 0을 만들 수 있는 경우 1로 초기화

            int value = coins[i][0];
            int cnt = coins[i][1];

            for (int j = 1; j <= cnt; j++) {
                int price = value * j; // 현재 동전을 j개 썼을 때 금액

                for (int k = price; k <= T; k++) {
                    dp[k][i + 1] += dp[k - price][i];
                }
            }

            for (int j = 1; j <= T; j++) {
                dp[j][i + 1] += dp[j][i];
            }
        }

        System.out.println(dp[T][K]);
    }

}
