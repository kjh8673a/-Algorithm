import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int v;
        int dist;

        public Node(int v, int dist) {
            this.v = v;
            this.dist = dist;
        }
    }

    static int n;
    static ArrayList<ArrayList<Node>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, dist));
            list.get(b).add(new Node(a, dist));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(bfs(a, b)).append("\n");
        }

        System.out.println(sb);
    }

    private static int bfs(int a, int b) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];

        queue.add(new Node(a, 0));
        visited[a] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.v == b) {
                return node.dist;
            }

            for (Node next : list.get(node.v)) {
                if (visited[next.v]) {
                    continue;
                }

                queue.add(new Node(next.v, node.dist + next.dist));
                visited[next.v] = true;
            }
        }

        return -1;
    }

}