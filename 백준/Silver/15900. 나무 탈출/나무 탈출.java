import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int cnt;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        cnt = 0;
        visited = new boolean[n + 1];
        dfs(1, 0);

        System.out.println(cnt % 2 == 0 ? "No" : "Yes");
    }

    private static void dfs(int node, int depth) {
        visited[node] = true;

        if (graph.get(node).size() == 1 && node != 1) {
            cnt += depth;
            return;
        }

        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }
    }

}