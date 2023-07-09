import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        dp = new boolean[N + 1][N + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            pal(S, E);
            if (dp[S][E]) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean pal(int s, int e) {
        if (dp[s][e]) {
            return true;
        }

        if (s == e) {
            return  dp[s][e] = true;
        } else {
            if (arr[s] == arr[e]) {
                if (s + 1 == e || pal(s + 1, e - 1)) {
                    return dp[s][e] = true;
                } else {
                    return dp[s][e] = false;
                }
            } else {
                return dp[s][e] = false;
            }
        }
    }
}
