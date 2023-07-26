import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int point;
        double dist;

        public Node(int point, double dist) {
            this.point = point;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(this.dist, o.dist);
        }
    }

    static ArrayList<ArrayList<Node>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] cord = new int[N + 1][2];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            cord[i][0] = Integer.parseInt(st.nextToken());
            cord[i][1] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList<>();
        for (int i = 1; i <= N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (i != j) {
                    double dist = Math
                            .sqrt(Math.pow((cord[i][0] - cord[j][0]), 2) + Math.pow((cord[i][1] - cord[j][1]), 2));
                    list.get(i).add(new Node(j, dist));
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.get(x).add(new Node(y, 0));
            list.get(y).add(new Node(x, 0));
        }

        prim(1, N);
    }

    private static void prim(int start, int n) {
        boolean[] visit = new boolean[n + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        double total = 0;
        int pick = 0;
        while (pick < n) {
            Node node = pq.poll();

            if (visit[node.point]) {
                continue;
            }

            visit[node.point] = true;
            total += node.dist;
            pick++;

            for (Node next : list.get(node.point)) {
                if (!visit[next.point]) {
                    pq.add(next);
                }
            }
        }

        System.out.printf("%.2f", total);
    }

}
