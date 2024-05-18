import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] graph, dp;
    static final int INF = 100_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][(1 << n) - 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(dfs(0, 1));
    }

    private static int dfs(int now, int visit) {
        if (visit == (1 << n) - 1) {
            if (graph[now][0] == 0) {
                return INF;
            }
            return graph[now][0];
        }

        if (dp[now][visit] != -1) {
            return dp[now][visit];
        }

        dp[now][visit] = INF;
        for (int i = 0; i < n; i++) {
            if ((visit & (1 << i)) == 0 && graph[now][i] != 0) {
                dp[now][visit] = Math.min(dfs(i, visit | (1 << i)) + graph[now][i], dp[now][visit]);
            }
        }

        return dp[now][visit];
    }

}