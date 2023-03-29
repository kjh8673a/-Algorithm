import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M + 1];
        int a = 0;
        int max = 0;
        for (int i = 0; i < M; i++) {
            int b = Integer.parseInt(br.readLine());
            arr[i] = b - a - 1;
            max = Math.max(max, arr[i]);
            a = b;
        }
        arr[M] = N - a;
        max = Math.max(max, arr[M]);

        int[] dp = new int[max + 1];
        dp[0] = 1;
        if (max > 0) {
            dp[1] = 1;
        }
        for (int i = 2; i < max + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int ans = 1;
        for (int i = 0; i < M + 1; i++) {
            ans *= dp[arr[i]];
        }

        System.out.println(ans);

    }
}
