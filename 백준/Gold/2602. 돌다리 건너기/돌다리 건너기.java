import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String route = br.readLine();
        String a = br.readLine();
        String b = br.readLine();

        int[][][] dp = new int[2][route.length() + 1][a.length() + 1];
        Arrays.fill(dp[0][0], 1);
        Arrays.fill(dp[1][0], 1);

        for (int i = 1; i < route.length() + 1; i++) {
            for (int j = 1; j < a.length() + 1; j++) {
                if (route.charAt(i - 1) == a.charAt(j - 1)) {
                    dp[0][i][j] = dp[0][i][j - 1] + dp[1][i - 1][j - 1];
                } else {
                    dp[0][i][j] = dp[0][i][j - 1];
                }

                if (route.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[1][i][j] = dp[1][i][j - 1] + dp[0][i - 1][j - 1];
                } else {
                    dp[1][i][j] = dp[1][i][j - 1];
                }
            }
        }

        int ans = dp[0][route.length()][a.length()] + dp[1][route.length()][a.length()];

        System.out.println(ans);
    }

}