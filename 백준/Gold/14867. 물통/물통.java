import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int a;
        int b;
        int cnt;

        public Node(int a, int b, int cnt) {
            this.a = a;
            this.b = b;
            this.cnt = cnt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Node)) {
                return false;
            }
            Node node = (Node) o;
            return this.a == node.a && this.b == node.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }

    static int A, B, C, D;
    static Queue<Node> queue;
    static Set<Node> visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int ans = bfs();

        System.out.println(ans);
    }

    private static int bfs() {
        queue = new LinkedList<>();
        visit = new HashSet<>();
        queue.add(new Node(0, 0, 0));
        visit.add(new Node(0, 0, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.a == C && node.b == D) {
                return node.cnt;
            }

            // Fill a
            operation(A, node.b, node.cnt + 1);
            // Fill b
            operation(node.a, B, node.cnt + 1);
            // Empty a
            operation(0, node.b, node.cnt + 1);
            // Empty b
            operation(node.a, 0, node.cnt + 1);

            int total = node.a + node.b;
            // a -> b
            if (total < B) {
                operation(0, total, node.cnt + 1);
            } else {
                operation(total - B, B, node.cnt + 1);
            }
            // b -> a
            if (total < A) {
                operation(total, 0, node.cnt + 1);
            } else {
                operation(A, total - A, node.cnt + 1);
            }
        }

        return -1;
    }

    private static void operation(int oa, int ob, int ocnt) {
        if (visit.contains(new Node(oa, ob, 0))) {
            return;
        }

        visit.add(new Node(oa, ob, 0));
        queue.add(new Node(oa, ob, ocnt));
    }

}