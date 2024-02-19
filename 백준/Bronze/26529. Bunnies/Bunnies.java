import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, input[i]);
        }

        long[] dp = new long[max + 1];
        dp[0] = 1;
        if (max > 0) {
            dp[1] = 1;
        }
        for (int i = 2; i < max + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        Arrays.stream(input).forEach(num -> System.out.println(dp[num]));
    }

}