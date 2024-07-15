import java.io.*;
import java.util.*;

public class Main {
    static class Dipendency {
        int v;
        int time;

        public Dipendency(int v, int time) {
            this.v = v;
            this.time = time;
        }
    }

    static StringBuilder sb;
    static int n;
    static ArrayList<ArrayList<Dipendency>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i < n + 1; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                graph.get(b).add(new Dipendency(a, s));
            }

            dijk(c);
        }

        System.out.println(sb);
    }

    private static void dijk(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Dipendency> pq = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
        boolean[] visited = new boolean[n + 1];
        pq.add(new Dipendency(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Dipendency node = pq.poll();

            if (visited[node.v]) {
                continue;
            }

            visited[node.v] = true;
            for (Dipendency next : graph.get(node.v)) {
                if (!visited[next.v] && dist[next.v] > dist[node.v] + next.time) {
                    dist[next.v] = dist[node.v] + next.time;
                    pq.add(new Dipendency(next.v, dist[next.v]));
                }
            }
        }

        int cnt = 0;
        int result = 0;
        for (int i = 1; i < n + 1; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                cnt++;
                result = Math.max(dist[i], result);
            }
        }

        sb.append(cnt + " " + result).append("\n");
    }

}