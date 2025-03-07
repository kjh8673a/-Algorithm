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
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int n, x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Node>> graphAtoB = new ArrayList<>();
        ArrayList<ArrayList<Node>> graphBtoA = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graphAtoB.add(new ArrayList<>());
            graphBtoA.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graphAtoB.get(b).add(new Node(a, c));
            graphBtoA.get(a).add(new Node(b, c));
        }

        int[] distAtoB = dijkstra(graphAtoB);
        int[] distBtoA = dijkstra(graphBtoA);

        int[] dist = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            dist[i] = distAtoB[i] + distBtoA[i];
        }
        Arrays.sort(dist);

        System.out.println(dist[n]);
    }

    private static int[] dijkstra(ArrayList<ArrayList<Node>> graph) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[x] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(x, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (dist[node.idx] < node.cost) {
                continue;
            }

            for (Node next : graph.get(node.idx)) {
                if (dist[next.idx] > next.cost + node.cost) {
                    dist[next.idx] = next.cost + node.cost;
                    pq.add(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        return dist;
    }
}