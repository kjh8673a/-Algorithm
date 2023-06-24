import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r;
        int c;
        int dist;

        public Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    static int N, M, ans;
    static int[][] board;
    static int[][] vector = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(ans);
    }

    private static void bfs(int r, int c) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];

        queue.add(new Node(r, c, 0));
        visit[r][c] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nr = node.r + vector[i][0];
                int nc = node.c + vector[i][1];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc]) {
                    continue;
                }

                if (board[nr][nc] == 1) {
                    ans = Math.max(ans, node.dist + 1);
                    return;
                }

                visit[nr][nc] = true;
                queue.add(new Node(nr, nc, node.dist + 1));
            }
        }
    }

}
