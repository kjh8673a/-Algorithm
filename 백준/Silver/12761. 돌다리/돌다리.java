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

    static int A, B, N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visit = new boolean[100001];

        queue.add(new Node(N, 0));
        visit[N] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.point == M) {
                return node.cnt;
            }

            for (int i = 0; i < 8; i++) {
                int next = move(node.point, i);

                if (next < 0 || next > 100000 || visit[next]) {
                    continue;
                }

                visit[next] = true;
                queue.add(new Node(next, node.cnt + 1));
            }
        }

        return 0;
    }

    private static int move(int curr, int type) {
        int next = 0;
        switch (type) {
            case 0:
                next = curr + 1;
                break;
            case 1:
                next = curr - 1;
                break;
            case 2:
                next = curr + A;
                break;
            case 3:
                next = curr - A;
                break;
            case 4:
                next = curr + B;
                break;
            case 5:
                next = curr - B;
                break;
            case 6:
                next = curr * A;
                break;
            case 7:
                next = curr * B;
                break;
        }

        return next;
    }

}