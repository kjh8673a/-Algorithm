import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        int max = -1;
        for (int i = 0; i < n + 1; i++) {
            max = Math.max(dp[i], max);

            if (i + arr[i][0] < n + 1) {
                dp[i + arr[i][0]] = Math.max(dp[i + arr[i][0]], max + arr[i][1]);
            }
        }

        System.out.println(max);
    }

}