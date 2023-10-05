import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] arr = new int[T];
        int max = 0;
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        int[] dp = new int[max + 1];
        Arrays.fill(dp, 1);

        for (int i = 2; i < max + 1; i++) {
            dp[i] += dp[i - 2];
        }

        for (int i = 3; i < max + 1; i++) {
            dp[i] += dp[i - 3];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            sb.append(dp[arr[i]]).append("\n");
        }

        System.out.println(sb);
    }

}
