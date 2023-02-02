import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, ans;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int Hx = Integer.parseInt(st.nextToken()) - 1;
        int Hy = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        int Ex = Integer.parseInt(st.nextToken()) - 1;
        int Ey = Integer.parseInt(st.nextToken()) - 1;

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = -1;
        bfs(Hx, Hy, Ex, Ey);
        System.out.println(ans);

    }

    static class Node {
        int r;
        int c;
        int dist;
        int magic;

        public Node(int r, int c, int dist, int magic) {
            this.r = r;
            this.c = c;
            this.dist = dist;
            this.magic = magic;
        }
    }

    static int[] dr = { 1, -1, 0, 0 };
    static int[] dc = { 0, 0, 1, -1 };

    public static void bfs(int hx, int hy, int ex, int ey) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(hx, hy, 0, 0));

        boolean[][][] visit = new boolean[N][M][2];
        visit[hx][hy][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.r == ex && node.c == ey) {
                ans = node.dist;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    continue;
                }

                if (node.magic < 1) {
                    if (board[nr][nc] == 1 && !visit[nr][nc][1]) {
                        queue.add(new Node(nr, nc, node.dist + 1, 1));
                        visit[nr][nc][1] = true;
                    } else if (board[nr][nc] == 0 && !visit[nr][nc][0]) {
                        queue.add(new Node(nr, nc, node.dist + 1, 0));
                        visit[nr][nc][0] = true;
                    }
                } else {
                    if (board[nr][nc] == 0 && !visit[nr][nc][1]) {
                        queue.add(new Node(nr, nc, node.dist + 1, 1));
                        visit[nr][nc][1] = true;
                    }
                }
            }

        }

    }

}