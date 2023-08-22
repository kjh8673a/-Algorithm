import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int point;
        int cnt;

        public Node(int point, int cnt) {
            this.point = point;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        System.out.println(bfs(A, B, N, M));
    }

    private static int bfs(int a, int b, int n, int m) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visit = new boolean[100001];

        queue.add(new Node(n, 0));
        visit[n] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.point == m) {
                return node.cnt;
            }

            if (node.point + 1 <= 100000 && !visit[node.point + 1]) {
                visit[node.point + 1] = true;
                queue.add(new Node(node.point + 1, node.cnt + 1));
            }

            if (node.point - 1 >= 0 && !visit[node.point - 1]) {
                visit[node.point - 1] = true;
                queue.add(new Node(node.point - 1, node.cnt + 1));
            }

            if (node.point + a <= 100000 && !visit[node.point + a]) {
                visit[node.point + a] = true;
                queue.add(new Node(node.point + a, node.cnt + 1));
            }

            if (node.point - a >= 0 && !visit[node.point - a]) {
                visit[node.point - a] = true;
                queue.add(new Node(node.point - a, node.cnt + 1));
            }

            if (node.point + b <= 100000 && !visit[node.point + b]) {
                visit[node.point + b] = true;
                queue.add(new Node(node.point + b, node.cnt + 1));
            }

            if (node.point - b >= 0 && !visit[node.point - b]) {
                visit[node.point - b] = true;
                queue.add(new Node(node.point - b, node.cnt + 1));
            }

            if (node.point * a <= 100000 && !visit[node.point * a]) {
                visit[node.point * a] = true;
                queue.add(new Node(node.point * a, node.cnt + 1));
            }

            if (node.point * b <= 100000 && !visit[node.point * b]) {
                visit[node.point * b] = true;
                queue.add(new Node(node.point * b, node.cnt + 1));
            }
        }

        return 0;
    }

}