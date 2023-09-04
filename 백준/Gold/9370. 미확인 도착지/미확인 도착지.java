import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node> {
        int v;
        int weight;

        public Node(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static int n;
    static ArrayList<ArrayList<Node>> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            for (int i = 1; i <= n + 1; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                list.get(a).add(new Node(b, d));
                list.get(b).add(new Node(a, d));
            }

            int[] dist_s = dijkstra(s);
            int[] dist_g = dijkstra(g);
            int[] dist_h = dijkstra(h);

            int[] goal = new int[t];
            for (int i = 0; i < t; i++) {
                goal[i] = Integer.parseInt(br.readLine());
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int x : goal) {
                int gh = dist_s[g] + dist_g[h] + dist_h[x];
                int hg = dist_s[h] + dist_h[g] + dist_g[x];
                int sx = dist_s[x];

                if (Math.min(gh, hg) == sx) {
                    pq.add(x);
                }
            }

            while (!pq.isEmpty()) {
                sb.append(pq.poll() + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int[] dijkstra(int st) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(st, 0));
        dist[st] = 0;

        boolean[] visit = new boolean[n + 1];

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (visit[node.v]) {
                continue;
            }
            visit[node.v] = true;

            for (Node next : list.get(node.v)) {
                if (!visit[next.v] && dist[next.v] > dist[node.v] + next.weight) {
                    dist[next.v] = dist[node.v] + next.weight;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }

        }

        return dist;
    }

}
