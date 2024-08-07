import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] subject = new int[k + 1][2];
        for (int i = 1; i < k + 1; i++) {
            st = new StringTokenizer(br.readLine());
            subject[i][0] = Integer.parseInt(st.nextToken());
            subject[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        for (int i = 1; i < k + 1; i++) {
            int importance = subject[i][0];
            int time = subject[i][1];

            for (int j = n; j > 0; j--) {
                if (time <= j) {
                    dp[j] = Math.max(dp[j], dp[j - time] + importance);
                }
            }
        }

        System.out.println(dp[n]);
    }

}