import java.io.*;
import java.util.*;

public class Main {
    static class Position {
        int r;
        int c;
        int dist;

        public Position(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    static int N, M, K;
    static int[][] board;
    static int[][] vector = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        Position start = new Position(0, 0, 0);
        ArrayList<Position> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 4) {
                    start = new Position(i, j, 0);
                } else if (board[i][j] == 3) {
                    list.add(new Position(i, j, 0));
                }
            }
        }

        makeWall(list);

        System.out.println(findChair(start));
    }

    private static int findChair(Position start) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(start);
        boolean[][] visit = new boolean[N][M];
        visit[start.r][start.c] = true;

        while (!queue.isEmpty()) {
            Position curr = queue.poll();

            if (board[curr.r][curr.c] == 2) {
                return curr.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + vector[i][0];
                int nc = curr.c + vector[i][1];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc] || board[nr][nc] == 1) {
                    continue;
                }

                visit[nr][nc] = true;
                queue.add(new Position(nr, nc, curr.dist + 1));
            }

        }

        return -1;
    }

    private static void makeWall(ArrayList<Position> list) {
        Queue<Position> queue = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];
        for (Position pos : list) {
            queue.add(pos);
            visit[pos.r][pos.c] = true;
        }

        while (!queue.isEmpty()) {
            Position curr = queue.poll();

            board[curr.r][curr.c] = 1;

            if (curr.dist == K) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + vector[i][0];
                int nc = curr.c + vector[i][1];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc]) {
                    continue;
                }

                visit[nr][nc] = true;
                queue.add(new Position(nr, nc, curr.dist + 1));
            }

        }
    }

}