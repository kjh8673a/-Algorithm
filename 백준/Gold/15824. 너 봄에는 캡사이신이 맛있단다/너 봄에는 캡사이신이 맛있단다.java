import java.util.*;
import java.io.*;

public class Main {
    static final int MOD = 1_000_000_007;
    static long[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dp = new long[N + 1];
        dp[0] = 1;
        long answer = 0;
        for (int i = 0; i < N; i++) {
            answer += arr[i] * pow(i);
            answer -= arr[i] * pow(N - i - 1);
            answer %= MOD;
        }

        System.out.println(answer);
    }

    public static long pow(int x) {
        if (dp[x] != 0) {
            return dp[x];
        }
        long half = pow(x / 2);
        if (x % 2 == 0) {
            return dp[x] = half * half % MOD;
        }
        return dp[x] = half * half * 2 % MOD;
    }

}