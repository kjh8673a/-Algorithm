import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int num;
        int time;

        public Node(int num, int time) {
            this.num = num;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.time, o.time);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] time = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                time[j] = Integer.parseInt(st.nextToken());
            }

            int[] in_degree = new int[N + 1];
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for (int j = 1; j <= N + 1; j++) {
                list.add(new ArrayList<>());
            }

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                in_degree[y]++;
                list.get(x).add(y);
            }

            int W = Integer.parseInt(br.readLine());

            PriorityQueue<Node> pq = new PriorityQueue<>();
            for (int j = 1; j < N + 1; j++) {
                if (in_degree[j] == 0) {
                    pq.add(new Node(j, time[j]));
                }
            }

            while (!pq.isEmpty()) {
                Node node = pq.poll();

                if (node.num == W) {
                    sb.append(node.time).append("\n");
                    break;
                }

                for (int next : list.get(node.num)) {
                    in_degree[next]--;
                    if (in_degree[next] == 0) {
                        pq.add(new Node(next, node.time + time[next]));
                    }
                }
            }
        }

        System.out.println(sb);
    }

}
