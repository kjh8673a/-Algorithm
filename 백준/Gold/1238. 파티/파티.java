import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

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

    static int n, m, x;
    static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // n명이 학생
        m = Integer.parseInt(st.nextToken()); // m개의 단방향 도로
        x = Integer.parseInt(st.nextToken()) - 1; // 파티 장소

        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int t = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, t));
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != x) {
                ans = Math.max(ans, dijk(i, x) + dijk(x, i));
            }
        }

        System.out.println(ans);
    }

    public static int dijk(int start, int end) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        boolean[] visit = new boolean[n];
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (visit[curr.v]) {
                continue;
            }
            visit[curr.v] = true;

            for (Node node : list[curr.v]) {
                if (!visit[node.v] && dist[node.v] > dist[curr.v] + node.weight) {
                    dist[node.v] = dist[curr.v] + node.weight;
                    pq.add(new Node(node.v, curr.weight + node.weight));
                }
            }
        }

        return dist[end];
    }

}