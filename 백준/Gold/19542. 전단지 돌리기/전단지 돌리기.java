import java.io.*;
import java.util.*;

public class Main {
    static int s, d, cnt;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        cnt = 0;
        visited = new boolean[n + 1];
        dfs(s);

        System.out.println(cnt * 2);
    }

    private static int dfs(int node) {
        visited[node] = true;

        int dist = 0;
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dist = Math.max(dist, dfs(next));
            }
        }

        if (dist >= d && node != s) {
            cnt++;
        }

        return dist + 1;
    }

}