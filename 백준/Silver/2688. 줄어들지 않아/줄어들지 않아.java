import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] testCase = new int[t];
        int max = 0;
        for (int i = 0; i < t; i++) {
            testCase[i] = Integer.parseInt(br.readLine());
            max = Math.max(testCase[i], max);
        }

        long[][] dp = new long[max + 1][10];
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i < max + 1; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k];
                }
            }
        }

        long[] result = new long[max + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            if (result[testCase[i]] == 0) {
                for (int j = 0; j < 10; j++) {
                    result[testCase[i]] += dp[testCase[i]][j];
                }
            }
            sb.append(result[testCase[i]]).append("\n");
        }

        System.out.println(sb);
    }

}