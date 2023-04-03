import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = { 1, -1, 0, 0 };
    static int[] dc = { 0, 0, 1, -1 };
    static int[][] board;
    static int N, K, cnt;

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        loop: for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) {
                    cnt = 0;
                    bfs(i, j);
                    ans += (cnt % K == 0 ? cnt / K : cnt / K + 1);
                }
                if (M - ans < 0) {
                    break loop;
                }
            }
        }

        if (ans == 0 || M - ans < 0) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println("POSSIBLE");
            System.out.println(M - ans);
        }

    }

    public static void bfs(int r, int c) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(r, c));

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (board[p.r][p.c] == 1) {
                continue;
            }
            board[p.r][p.c] = 1;
            cnt++;

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N || board[nr][nc] == 1) {
                    continue;
                }
                queue.add(new Point(nr, nc));
            }
        }

    }
}
