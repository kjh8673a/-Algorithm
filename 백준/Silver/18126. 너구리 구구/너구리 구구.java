import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int idx;
        long cost;

        public Node(int idx, long cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Long c = Long.parseLong(st.nextToken());

            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }

        long[] dist = new long[N + 1];
        boolean[] visit = new boolean[N + 1];
        Queue<Node> queue = new LinkedList<>();

        visit[1] = true;
        queue.add(new Node(1, 0));

        long ans = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (Node next : list.get(node.idx)) {
                if (visit[next.idx]) {
                    continue;
                }
                dist[next.idx] = node.cost + next.cost;
                visit[next.idx] = true;
                ans = Math.max(ans, dist[next.idx]);
                queue.add(new Node(next.idx, dist[next.idx]));
            }
        }

        System.out.println(ans);
    }

}
