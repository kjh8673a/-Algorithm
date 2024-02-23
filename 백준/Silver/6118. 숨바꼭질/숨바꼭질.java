import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dist = new int[n + 1];
        int max = bfs();
        int num = 0;
        int cnt = 0;

        for (int i = 1; i < dist.length; i++) {
            if (dist[i] == max) {
                cnt++;
                if (num == 0) {
                    num = i;
                }
            }
        }

        System.out.println(num + " " + max + " " + cnt);
    }

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.add(1);
        visited[1] = true;

        int result = -1;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                int node = queue.poll();
                dist[node] = cnt;
                result = Math.max(result, cnt);
                for (int next : graph.get(node)) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
            }

            cnt++;
        }

        return result;
    }

}