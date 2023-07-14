import java.io.*;
import java.util.*;

public class Main {
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        dp = new long[55];
        dp[0] = 1;
        for (int i = 1; i < 55; i++) {
            dp[i] = (dp[i - 1] << 1) + (1L << i);
        }

        long ans = count(B) - count(A - 1);

        System.out.println(ans);
    }

    private static long count(long n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int digit = 0;
        long num = 1;
        while (num * 2 <= n) {
            num *= 2;
            digit++;
        }

        long diff = n - num + 1;

        return dp[digit - 1] + diff + count(n - num);
    }

}
