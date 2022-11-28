import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            doDp(i);
        }

        int max = dp[0];
        for(int i = 0; i < N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(N-max);

    }

    public static int doDp(int idx) {
        if(dp[idx] == 0) {
            dp[idx] = 1;

            for(int i = idx - 1; i >= 0; i--) {
                if(arr[i] > arr[idx]) {
                    dp[idx] = Math.max(dp[idx], doDp(i) + 1);
                }
            }
        }

        return dp[idx];
    }

}