import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int a;
        int b;
        int cost;

        public Node(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int N, M;
    static int[] parent;
    static long sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sum = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            sum += c;
            pq.add(new Node(a, b, c));
        }

        parent = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }

        System.out.println(doKruskal(pq));
    }

    private static long doKruskal(PriorityQueue<Node> pq) {
        long total = 0;
        int cnt = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int px = findSet(node.a);
            int py = findSet(node.b);

            if (px != py) {
                total += node.cost;
                union(node.a, node.b);
                cnt++;
            }

            if (cnt == N - 1) {
                return sum - total;
            }
        }

        return -1;
    }

    private static void union(int a, int b) {
        int px = findSet(a);
        int py = findSet(b);

        if (px > py) {
            parent[py] = px;
        } else {
            parent[px] = py;
        }
    }

    private static int findSet(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            return parent[x] = findSet(parent[x]);
        }
    }

}
