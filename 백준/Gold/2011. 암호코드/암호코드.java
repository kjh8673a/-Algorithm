import java.io.*;

public class Main {
    static final int MOD = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[s.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            arr[i] = s.charAt(i - 1) - '0';
        }

        if (arr[1] == 0) {
            System.out.println(0);
        } else {
            int[] dp = new int[s.length() + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= s.length(); i++) {
                if (arr[i] == 0) {
                    if (arr[i - 1] == 1 || arr[i - 1] == 2) {
                        dp[i] += dp[i - 2] % MOD;
                    } else {
                        break;
                    }
                } else {
                    int num = arr[i - 1] * 10 + arr[i];
                    if (num <= 26 && num >= 10) {
                        dp[i] += dp[i - 2] % MOD;
                    }
                    dp[i] += dp[i - 1] % MOD;
                }

            }

            System.out.println(dp[s.length()] % MOD);
        }
    }

}