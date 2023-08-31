import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[d + 1][2];
        dp[1][0] = 1;
        dp[2][1] = 1;
        for (int i = 3; i < d + 1; i++) {
            dp[i][0] = dp[i - 2][0] + dp[i - 1][0];
            dp[i][1] = dp[i - 2][1] + dp[i - 1][1];
        }

        for (int i = 1; i < k; i++) {
            int a = dp[d][0] * i;
            if ((k - a) % dp[d][1] == 0) {
                System.out.println(i);
                System.out.println((k - a) / dp[d][1]);
                break;
            }
        }
    }

}
