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
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static int[] item, dist;
    static List<Node>[] list;
    static int n, m, r, thisCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 지역의 개수
        m = Integer.parseInt(st.nextToken()); // 수색범위
        r = Integer.parseInt(st.nextToken()); // 길의 개수

        item = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            item[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        dist = new int[n + 1];

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, cost));
            list[b].add(new Node(a, cost));
        }

        int ans = 0;
        for (int i = 1; i < n + 1; i++) {
            thisCnt = 0;
            cal(i);
            ans = Math.max(ans, thisCnt);
        }

        System.out.println(ans);

    }

    public static void cal(int point) {
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        boolean visit[] = new boolean[n + 1];
        pq.add(new Node(point, 0));
        dist[point] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (visit[curr.to]) {
                continue;
            }
            visit[curr.to] = true;

            for (Node node : list[curr.to]) {
                if (!visit[node.to] && dist[node.to] > dist[curr.to] + node.cost) {
                    dist[node.to] = dist[curr.to] + node.cost;
                    pq.add(new Node(node.to, curr.cost + node.cost));
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            if (dist[i] <= m) {
                thisCnt += item[i];
            }
        }
    }

}