import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int r;
        int c;
        int cnt;
        int wall;

        public Node(int r, int c, int cnt, int wall) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.wall = wall;
        }
    }

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    static int N, M, K;
    static int[][] board;
    static boolean[][][] visit;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }

        visit = new boolean[N][M][K + 1];
        ans = -1;
        bfs();

        System.out.println(ans);

    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1, 0));
        visit[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int r = node.r;
            int c = node.c;

            if (r == N - 1 && c == M - 1) {
                ans = node.cnt;
                return;
            }

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    continue;
                }

                if (board[nr][nc] == 1 && node.wall < K && !visit[nr][nc][node.wall + 1]) {
                    visit[nr][nc][node.wall + 1] = true;
                    queue.add(new Node(nr, nc, node.cnt + 1, node.wall + 1));
                } else if (board[nr][nc] == 0 && !visit[nr][nc][node.wall]) {
                    visit[nr][nc][node.wall] = true;
                    queue.add(new Node(nr, nc, node.cnt + 1, node.wall));
                }
            }
        }

    }

}