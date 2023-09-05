import java.util.*;
import java.io.*;

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

    static int[][] vector = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    static int N, M, ans, len;
    static int[][] board;

    public static void main(String[] args) throws Exception {
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
        len = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != 0) {
                    bfs(i, j, board[i][j]);
                }
            }
        }

        System.out.println(ans);
    }

    private static void bfs(int r, int c, int start) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(r, c, 0));

        boolean[][] visit = new boolean[N][M];
        visit[r][c] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            boolean flag = false;
            for (int i = 0; i < 4; i++) {
                int nr = node.r + vector[i][0];
                int nc = node.c + vector[i][1];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc]) {
                    continue;
                }

                if (board[nr][nc] != 0) {
                    flag = true;
                    visit[nr][nc] = true;
                    queue.add(new Node(nr, nc, node.dist + 1));
                }
            }

            if (!flag && node.dist >= len) {
                if (node.dist > len) {
                    ans = start + board[node.r][node.c];
                } else {
                    ans = Math.max(ans, start + board[node.r][node.c]);
                }
                len = node.dist;
            }
        }
    }

}
