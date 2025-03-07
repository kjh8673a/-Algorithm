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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(n, 0));

        int[] dist = new int[100001];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;

        int answer = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.idx == k) {
                answer = Math.min(answer, node.cost);
                continue;
            }

            if (node.cost > answer) {
                continue;
            }

            if (dist[node.idx] < node.cost) {
                continue;
            }

            if (node.idx + 1 <= 100000 && dist[node.idx + 1] > node.cost + 1) {
                dist[node.idx + 1] = node.cost + 1;
                pq.add(new Node(node.idx + 1, dist[node.idx + 1]));
            }

            if (node.idx - 1 >= 0 && dist[node.idx - 1] > node.cost + 1) {
                dist[node.idx - 1] = node.cost + 1;
                pq.add(new Node(node.idx - 1, dist[node.idx - 1]));
            }

            if (node.idx * 2 <= 100000 && dist[node.idx * 2] > node.cost) {
                dist[node.idx * 2] = node.cost;
                pq.add(new Node(node.idx * 2, dist[node.idx * 2]));
            }
        }

        System.out.println(answer);
    }
}