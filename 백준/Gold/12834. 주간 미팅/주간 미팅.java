import java.io.*;
import java.util.*;

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

    static int N, V, E;
    static ArrayList<ArrayList<Node>> graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 사람의 수
        V = Integer.parseInt(st.nextToken()); // 장소의 수
        E = Integer.parseInt(st.nextToken()); // 도로의 수

        graph = new ArrayList<ArrayList<Node>>();
        for (int i = 0; i < V + 1; i++) {
            graph.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] team = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            team[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, l));
            graph.get(b).add(new Node(a, l));
        }

        dist = new int[V + 1];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist, Integer.MAX_VALUE);
            dijk(team[i], A);
            sum += (dist[A] == Integer.MAX_VALUE ? -1 : dist[A]);

            Arrays.fill(dist, Integer.MAX_VALUE);
            dijk(team[i], B);
            sum += (dist[B] == Integer.MAX_VALUE ? -1 : dist[B]);
        }

        System.out.println(sum);

    }

    private static void dijk(int st, int ed) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[V + 1];
        pq.add(new Node(st, 0));
        dist[st] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (visit[curr.v]) {
                continue;
            }
            visit[curr.v] = true;

            // 연결된 정점 비교
            for (Node node : graph.get(curr.v)) {
                // "인접 정점이 현재 가지는 최소비용"과
                // "현재 선택된 정점의 값 + 현재 정점에서 인접 정점으로 가는 값"을 비교하여 작은 값으로 갱신
                if (!visit[node.v] && dist[node.v] > dist[curr.v] + node.weight) {
                    dist[node.v] = dist[curr.v] + node.weight;
                    pq.add(new Node(node.v, dist[node.v]));
                }
            }
        }

    }

}