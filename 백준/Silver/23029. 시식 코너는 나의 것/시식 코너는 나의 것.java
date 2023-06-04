import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N + 1];
        dp[1] = arr[1];
        if (N > 1) {
            dp[2] = Math.max(arr[1] + arr[2] / 2, arr[2]);
        }

        for (int i = 3; i < N + 1; i++) {
            dp[i] = Math.max(dp[i - 2] + arr[i], Math.max(dp[i - 1], dp[i - 3] + arr[i - 1] + arr[i] / 2));
        }

        System.out.println(dp[N]);
    }

}