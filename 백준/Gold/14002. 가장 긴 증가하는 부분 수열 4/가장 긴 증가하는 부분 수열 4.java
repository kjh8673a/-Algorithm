import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            doDp(i);
        }

        int max = dp[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }

        sb.append(max).append("\n");

        String ans = "";
        int val = max;

        for(int i = n-1; i >= 0; i--) {
            if(val == dp[i]) {
                if(val == 1) {
                    ans = arr[i] + ans;
                }else {
                    ans = " " + arr[i] + ans;
                }
                val--;
            }
        }

        sb.append(ans);

        System.out.println(sb.toString());

    }

    public static int doDp(int idx) {

        if (dp[idx] == 0) {
            dp[idx] = 1;

            for (int i = idx - 1; i >= 0; i--) {
                if (arr[i] < arr[idx]) {
                    dp[idx] = Math.max(dp[idx], doDp(i) + 1);
                }
            }

        }

        return dp[idx];

    }
}