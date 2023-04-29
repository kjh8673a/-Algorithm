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

    static int N;
    static char[][] board;
    static ArrayList<Point> teacher;
    static int[] dr = { 1, -1, 0, 0 };
    static int[] dc = { 0, 0, 1, -1 };
    static boolean isClear;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        teacher = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = st.nextToken().charAt(0);
                if (board[i][j] == 'T') {
                    teacher.add(new Point(i, j));
                }
            }
        }

        isClear = false;
        makeWall(0);

        System.out.println(isClear ? "YES" : "NO");

    }

    static void makeWall(int cnt) {
        if (cnt == 3) {
            if (clear() && !isClear) {
                isClear = true;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'X') {
                    board[i][j] = 'O';
                    makeWall(cnt + 1);
                    board[i][j] = 'X';
                }
            }
        }
    }

    static boolean clear() {
        for (Point t : teacher) {
            for (int i = 0; i < 4; i++) {
                int nr = t.r;
                int nc = t.c;
                while (nr >= 0 && nc >= 0 && nr < N && nc < N) {
                    if (board[nr][nc] == 'O') {
                        break;
                    } else if (board[nr][nc] == 'S') {
                        return false;
                    }
                    nr += dr[i];
                    nc += dc[i];
                }
            }
        }
        return true;
    }

}