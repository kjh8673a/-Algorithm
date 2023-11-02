import java.util.*;
import java.io.*;

public class Main {
    static class Pipe {
        int length;
        int count;

        public Pipe(int length, int count) {
            this.length = length;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        Pipe[] arr = new Pipe[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[i] = new Pipe(l, c);
        }

        int[] dp = new int[x + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int len = arr[i].length;
            int cnt = arr[i].count;

            for (int j = x; j >= 0; j--) {
                for (int k = 1; k <= cnt && j - k * len >= 0; k++) {
                    dp[j] += dp[j - k * len];
                }
            }
        }

        System.out.println(dp[x]);
    }

}