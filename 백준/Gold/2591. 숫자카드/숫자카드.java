import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String number = br.readLine();

        int[][] dp = new int[number.length()][2];
        dp[0][0] = 1;
        dp[0][1] = 0;

        int ans = 1;
        if (number.charAt(0) - '0' == 0) {
            ans = 0;
        }
        for (int i = 1; i < number.length(); i++) {
            int num = (number.charAt(i - 1) - '0') * 10 + (number.charAt(i) - '0');
            if (number.charAt(i) - '0' == 0) {
                if (num > 34) {
                    ans = 0;
                    break;
                } else {
                    dp[i][0] = 0;
                    dp[i][1] = dp[i - 1][0];
                }
            } else if (num > 34) {
                dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
                dp[i][1] = 0;
            } else {
                dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
                dp[i][1] = dp[i - 1][0];
            }
        }

        if (ans != 0) {
            ans = dp[number.length() - 1][0] + dp[number.length() - 1][1];
        }
        System.out.println(ans);
    }
}