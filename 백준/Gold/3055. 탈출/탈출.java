import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[][] vector = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Queue<Point> hedgehog = new LinkedList<>();
        Queue<Point> water = new LinkedList<>();
        boolean[][] visited = new boolean[r][c];

        char[][] board = new char[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == '*') {
                    water.add(new Point(i, j));
                }
                if (board[i][j] == 'S') {
                    hedgehog.add(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int answer = 0;
        int time = 0;
        loop: while (!hedgehog.isEmpty()) {
            int waterLen = water.size();
            for (int i = 0; i < waterLen; i++) {
                Point node = water.poll();
                for (int k = 0; k < 4; k++) {
                    int nr = node.r + vector[k][0];
                    int nc = node.c + vector[k][1];

                    if (nr < 0 || nc < 0 || nr >= r || nc >= c) {
                        continue;
                    }
                    if (board[nr][nc] == '*' || board[nr][nc] == 'X' || board[nr][nc] == 'D') {
                        continue;
                    }

                    board[nr][nc] = '*';
                    water.add(new Point(nr, nc));
                }
            }

            int hedgehogLen = hedgehog.size();
            for (int i = 0; i < hedgehogLen; i++) {
                Point node = hedgehog.poll();
                if (board[node.r][node.c] == 'D') {
                    answer = time;
                    break loop;
                }

                for (int k = 0; k < 4; k++) {
                    int nr = node.r + vector[k][0];
                    int nc = node.c + vector[k][1];

                    if (nr < 0 || nc < 0 || nr >= r || nc >= c) {
                        continue;
                    }
                    if (board[nr][nc] == '*' || board[nr][nc] == 'X') {
                        continue;
                    }
                    if (visited[nr][nc]) {
                        continue;
                    }

                    visited[nr][nc] = true;
                    hedgehog.add(new Point(nr, nc));
                }
            }

            time++;
        }

        System.out.println(answer == 0 ? "KAKTUS" : answer);
    }

}