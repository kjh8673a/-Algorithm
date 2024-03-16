import java.io.*;
import java.util.*;

public class Main {
    static int[][] vector = { { 1, 0 }, { 0, 1 } };

    static int n;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = dijkstra();

        System.out.println(answer);
    }

    private static int dijkstra() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));

        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int k = 0; k < 2; k++) {
                int nr = node.r + vector[k][0];
                int nc = node.c + vector[k][1];

                if (nr < 0 || nc < 0 || nr >= n || nc >= n) {
                    continue;
                }

                int tmp = 0;
                if (board[node.r][node.c] <= board[nr][nc]) {
                    tmp = board[nr][nc] - board[node.r][node.c] + 1;
                }

                if (dist[nr][nc] > tmp + dist[node.r][node.c]) {
                    dist[nr][nc] = tmp + dist[node.r][node.c];
                    queue.add(new Node(nr, nc));
                }
            }
        }

        return dist[n - 1][n - 1];
    }

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}