import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        dp = new int[N + 1][N + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            pal(S, E);
            if (dp[S][E] == 1) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean pal(int s, int e) {
        if (dp[s][e] == 1) {
            return true;
        } else if (dp[s][e] == -1) {
            return false;
        }

        if (s == e) {
            dp[s][e] = 1;
            return true;
        } else {
            if (arr[s] == arr[e]) {
                if (s + 1 == e) {
                    dp[s][e] = 1;
                    return true;
                }

                if (pal(s + 1, e - 1)) {
                    dp[s][e] = 1;
                    return true;
                } else {
                    dp[s][e] = -1;
                    return false;
                }
            } else {
                dp[s][e] = -1;
                return false;
            }
        }
    }
}
