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
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }

        System.out.println(dijkstra());
    }

    private static int dijkstra() {
        boolean[] visit = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (visit[curr.v]) {
                continue;
            }
            visit[curr.v] = true;

            for (Node next : list.get(curr.v)) {
                if (!visit[next.v] && dist[next.v] > dist[curr.v] + next.cost) {
                    dist[next.v] = dist[curr.v] + next.cost;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }

        return dist[N];
    }

}
