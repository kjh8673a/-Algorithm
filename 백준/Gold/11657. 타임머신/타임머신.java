import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static int n, m;
    static ArrayList<ArrayList<Node>> list;
    static long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        dist = new long[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, c));
        }

        boolean flag = bellmanFord();

        StringBuilder sb = new StringBuilder();
        if (flag) {
            for (int i = 2; i <= n; i++) {
                if (dist[i] == Integer.MAX_VALUE) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(dist[i]).append("\n");
                }
            }
        } else {
            sb.append(-1).append("\n");
        }

        System.out.println(sb);
    }

    private static boolean bellmanFord() {
        dist[1] = 0;
        boolean flag = false;

        for (int i = 0; i < n - 1; i++) {
            flag = false;

            for (int j = 1; j <= n; j++) {
                for (Node node : list.get(j)) {
                    if (dist[j] == Integer.MAX_VALUE) {
                        break;
                    }

                    if (dist[node.v] > dist[j] + node.cost) {
                        dist[node.v] = dist[j] + node.cost;
                        flag = true;
                    }
                }
            }

            if (!flag) {
                break;
            }
        }

        if (flag) {
            for (int i = 1; i <= n; i++) {
                for (Node node : list.get(i)) {
                    if (dist[i] == Integer.MAX_VALUE) {
                        break;
                    }

                    if (dist[node.v] > dist[i] + node.cost) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

}