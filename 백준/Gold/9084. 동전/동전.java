import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[] coins = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            int M = Integer.parseInt(br.readLine());

            int[][] dp = new int[N + 1][M + 1];

            for (int i = 1; i < N + 1; i++) {
                int now = coins[i];
                for(int j = 0; j < M + 1; j++) {
                    if(now <= j) {
                        int cnt = 0;
                        while(now * cnt < j) {
                            dp[i][j] += dp[i-1][j - now*cnt];
                            cnt++;
                        }
                    }else {
                        dp[i][j] = dp[i-1][j];
                    }
                    if(j % now == 0) {
                        dp[i][j]++;
                    }
                }
            }
            
            sb.append(dp[N][M]).append("\n");

        }

        System.out.println(sb.toString());

    }

}