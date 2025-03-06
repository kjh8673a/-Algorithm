import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Main.Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, w));
        }

        int[] dist = new int[v + 1];
        for (int i = 0; i < v + 1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(k, 0));
        dist[k] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (dist[node.idx] < node.cost) {
                continue;
            }

            for (Node next : graph.get(node.idx)) {
                if (dist[next.idx] > node.cost + next.cost) {
                    dist[next.idx] = node.cost + next.cost;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < v + 1; i++) {
            sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append("\n");
        }

        System.out.println(sb.toString());
    }
}