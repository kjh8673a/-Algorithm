import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int point;
        int cost;

        public Node(int point, int cost) {
            this.point = point;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int n, m, cnt;
    static ArrayList<ArrayList<Node>> list;
    static Node[] dist;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 1; i <= n + 1; i++) {
            list.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, c));
        }

        dist = new Node[n + 1];
        Arrays.fill(dist, new Node(0, Integer.MAX_VALUE));

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijk(start);

        cnt = 0;
        stack = new Stack<>();
        track(end);

        StringBuilder sb = new StringBuilder();
        sb.append(dist[end].cost).append("\n");
        sb.append(cnt).append("\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);
    }

    private static void track(int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(end);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            cnt++;
            stack.add(node);
            if (dist[node].point != 0) {
                queue.add(dist[node].point);
            }
        }
    }

    private static void dijk(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[n + 1];

        pq.offer(new Node(start, 0));
        dist[start] = new Node(0, 0);

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (visit[node.point]) {
                continue;
            }
            visit[node.point] = true;

            for (Node next : list.get(node.point)) {
                if (!visit[next.point] && dist[next.point].cost > dist[node.point].cost + next.cost) {
                    dist[next.point] = new Node(node.point, dist[node.point].cost + next.cost);
                    pq.add(new Node(next.point, dist[next.point].cost));
                }
            }
        }
    }

}
