import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int v;
        double weight;
        int count;

        public Node(int v, double weight, int count) {
            this.v = v;
            this.weight = weight;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return Double.compare(this.weight, o.weight);
        }
    }

    static int n, k;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                int w = line.charAt(j) - '0';
                graph[i][j] = w;
            }
        }

        double answer = dijkstra();
        System.out.println(answer);
    }

    private static double dijkstra() {
        double[][] dist = new double[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0, 0));
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            for (int i = 0; i < n; i++) {
                if (n == node.v) {
                    continue;
                }
                double nextCost = dist[node.v][node.count] + graph[node.v][i];
                if (dist[i][node.count] > nextCost) {
                    dist[i][node.count] = nextCost;
                    pq.add(new Node(i, dist[i][node.count], node.count));
                }

                nextCost = dist[node.v][node.count] + (graph[node.v][i] / 2.0);
                if (node.count < k) {
                    if (dist[i][node.count + 1] > nextCost) {
                        dist[i][node.count + 1] = nextCost;
                        pq.add(new Node(i, dist[i][node.count + 1], node.count + 1));
                    }
                }
            }
        }

        double answer = Integer.MAX_VALUE;
        for (int i = 0; i < k + 1; i++) {
            answer = Math.min(answer, dist[1][i]);
        }

        return answer;
    }

}