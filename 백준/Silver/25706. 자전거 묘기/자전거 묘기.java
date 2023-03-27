import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[N - 1] = 1;
        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] + i + 1 < N) {
                dp[i] = dp[i + arr[i] + 1] + 1;
            } else {
                dp[i] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(dp[i] + " ");
        }
        System.out.println(sb);
    }
}
