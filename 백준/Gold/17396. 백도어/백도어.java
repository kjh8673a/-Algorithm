import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int v;
        long weight;

        public Node(int v, long weight) {
            this.v = v;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] ward = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ward[i] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
            if (i == N - 1) {
                ward[i] = false;
            }
        }

        ArrayList<ArrayList<Node>> list = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            if (ward[a] || ward[b]) {
                continue;
            }
            list.get(a).add(new Node(b, t));
            list.get(b).add(new Node(a, t));
        }

        long[] dist = new long[N];
        for (int i = 0; i < N; i++) {
            dist[i] = Long.MAX_VALUE;
        }

        boolean[] visit = new boolean[N];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));
        dist[0] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (visit[curr.v]) {
                continue;
            }
            visit[curr.v] = true;

            for (Node node : list.get(curr.v)) {
                if (!visit[node.v] && dist[node.v] > dist[curr.v] + node.weight) {
                    dist[node.v] = dist[curr.v] + node.weight;
                    pq.add(new Node(node.v, dist[node.v]));
                }
            }
        }

        System.out.println(dist[N - 1] == Long.MAX_VALUE ? -1 : dist[N - 1]);

    }

}