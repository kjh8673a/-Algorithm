import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 1; i <= n + 1; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }

        visited = new boolean[n + 1];
        dp = new int[n + 1][2];
        dfs(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    private static void dfs(int node) {
        visited[node] = true;
        dp[node][1] = 1;

        for (int next : list.get(node)) {
            if (visited[next]) {
                continue;
            }

            dfs(next);
            dp[node][0] += dp[next][1];
            dp[node][1] += Math.min(dp[next][1], dp[next][0]);
        }
    }

}
