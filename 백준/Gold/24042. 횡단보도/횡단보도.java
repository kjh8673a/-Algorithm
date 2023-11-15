import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node> {
        int idx;
        long cost;

        public Node(int idx, long cost) {
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    static int N, M;
    static ArrayList<ArrayList<Node>> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 1; i <= N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, i));
            list.get(b).add(new Node(a, i));
        }

        System.out.println(dijkstra());
    }

    private static long dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));

        long[] dist = new long[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.cost > dist[curr.idx]) {
                continue;
            }

            for (Node next : list.get(curr.idx)) {
                long nextCost = curr.cost + ((next.cost - curr.cost) % M + M) % M + 1;
                if (dist[next.idx] > nextCost) {
                    dist[next.idx] = nextCost;
                    pq.offer(new Node(next.idx, nextCost));
                }
            }
        }

        return dist[N];
    }

}