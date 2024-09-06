import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        bfs(n, graph, k, x);
    }

    private static void bfs(int n, ArrayList<ArrayList<Integer>> graph, int k, int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);

        boolean[] visited = new boolean[n + 1];
        visited[x] = true;

        int distance = 0;
        while (!queue.isEmpty() && distance < k) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int node = queue.poll();

                for (int next : graph.get(node)) {
                    if (visited[next]) {
                        continue;
                    }

                    visited[next] = true;
                    queue.add(next);
                }
            }

            distance++;
        }

        if (queue.size() > 0) {
            StringBuilder sb = new StringBuilder();
            queue.stream().sorted().forEach(a -> sb.append(a).append("\n"));
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }
}