import java.io.*;
import java.util.*;

public class Main {

    public static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

    }

    static int[] dr = { 1, -1, 0, 0 };
    static int[] dc = { 0, 0, 1, -1 };
    static int N, M, cnt, time;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1) {
                    cnt++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        time = 0;
        while (cnt > 0) {
            int now = bfs();
            if (now > 0) {
                time++;
            }

            if (cnt - now == 0) {
                sb.append(time).append("\n");
                sb.append(cnt).append("\n");
            }

            cnt -= now;
        }

        System.out.println(sb);

    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));

        boolean[][] visit = new boolean[N][M];
        visit[0][0] = true;

        int remove = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc]) {
                    continue;
                }

                if (board[nr][nc] == 0) {
                    queue.add(new Node(nr, nc));
                } else {
                    remove++;
                    board[nr][nc] = 0;
                }

                visit[nr][nc] = true;
            }
        }

        return remove;

    }

}