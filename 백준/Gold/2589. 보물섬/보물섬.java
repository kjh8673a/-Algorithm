import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Point {
        int x;
        int y;
        int time;

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static int[][] board;
    static int N, M, ans;
    static int dr[] = { 1, -1, 0, 0 };
    static int dc[] = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j) == 'W' ? 0 : 1;
            }
        }

        ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(ans);
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];

        queue.add(new Point(x, y, 0));
        visit[x][y] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.x + dr[i];
                int nc = p.y + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    continue;
                }

                if (!visit[nr][nc] && board[nr][nc] == 1) {
                    visit[nr][nc] = true;
                    queue.add(new Point(nr, nc, p.time + 1));
                    ans = Math.max(ans, p.time + 1);
                }
            }
        }

    }

}