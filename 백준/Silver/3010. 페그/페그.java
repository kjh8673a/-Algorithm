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

    static int[][] vector = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] board = new char[7][7];
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < 7; i++) {
            String line = br.readLine();
            for (int j = 0; j < 7; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == '.') {
                    queue.add(new Point(i, j));
                }
            }
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + vector[i][0];
                int nc = p.c + vector[i][1];

                if (nr < 0 || nc < 0 || nr >= 7 || nc >= 7) {
                    continue;
                }

                if (board[nr][nc] == 'o') {
                    nr += vector[i][0];
                    nc += vector[i][1];

                    if (nr < 0 || nc < 0 || nr >= 7 || nc >= 7) {
                        continue;
                    }

                    if (board[nr][nc] == 'o') {
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);
    }

}
