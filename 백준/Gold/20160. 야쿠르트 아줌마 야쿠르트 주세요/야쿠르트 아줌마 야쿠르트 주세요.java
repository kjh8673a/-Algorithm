import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node> {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int V, E;
    static ArrayList<ArrayList<Node>> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 1; i <= V + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.get(u).add(new Node(v, w));
            list.get(v).add(new Node(u, w));
        }

        Queue<Integer> yogurtMadam = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            yogurtMadam.add(Integer.parseInt(st.nextToken()));
        }

        int myStart = Integer.parseInt(br.readLine());

        int[] myDist = dijkstra(myStart);

        long time = 0;
        int ans = 10001;

        if (myStart == yogurtMadam.peek()) {
            ans = myStart;
        }

        while (yogurtMadam.size() > 1) {
            int cur = yogurtMadam.poll();

            int[] dist = dijkstra(cur);

            while (!yogurtMadam.isEmpty() && dist[yogurtMadam.peek()] == Integer.MAX_VALUE) {
                yogurtMadam.poll();
            }

            if (!yogurtMadam.isEmpty()) {
                int next = yogurtMadam.peek();
                time += dist[next];
                if (myDist[next] <= time) {
                    ans = Math.min(ans, next);
                }
            }
        }

        System.out.println(ans == 10001 ? -1 : ans);
    }

    private static int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.cost > dist[cur.v]) {
                continue;
            }

            for (Node next : list.get(cur.v)) {
                if (dist[next.v] > dist[cur.v] + next.cost) {
                    dist[next.v] = dist[cur.v] + next.cost;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }

        return dist;
    }

}