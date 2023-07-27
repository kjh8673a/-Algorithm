import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int point;
        int cost;

        public Node(int point, int cost) {
            this.point = point;
            this.cost = cost;
        }
    }

    static ArrayList<ArrayList<Node>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 1; i <= N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }

        PriorityQueue<Node> pqMax = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        int max = prim(0, N, pqMax);

        PriorityQueue<Node> pqMin = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.cost, o1.cost));
        int min = prim(0, N, pqMin);

        System.out.println((int) (Math.pow(max, 2) - Math.pow(min, 2)));
    }

    private static int prim(int start, int n, PriorityQueue<Node> pq) {
        boolean[] visit = new boolean[n + 1];

        pq.add(new Node(start, 0));

        int cnt = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (visit[node.point]) {
                continue;
            }

            visit[node.point] = true;
            if (node.cost == 1) {
                cnt++;
            }

            for (Node next : list.get(node.point)) {
                if (!visit[next.point]) {
                    pq.add(next);
                }
            }
        }

        return n - cnt;
    }

}
