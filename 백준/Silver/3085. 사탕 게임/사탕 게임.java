import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static char[][] board;
    static int[] dr = { 1, 0 };
    static int[] dc = { 0, 1 };
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new char[N][N];

        ans = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = s.charAt(j);
            }
            ans = Math.max(checkRow(i), ans);
        }

        for (int i = 0; i < N; i++) {
            ans = Math.max(checkCol(i), ans);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                checkSwap(i, j);
            }
        }

        System.out.println(ans);
    }

    public static int checkRow(int x) {
        int len = 1;
        int max = 1;
        char c = board[x][0];
        for (int i = 1; i < N; i++) {
            if (board[x][i] == c) {
                len++;
                max = Math.max(max, len);
            } else {
                len = 1;
                c = board[x][i];
            }
        }
        return max;
    }

    public static int checkCol(int y) {
        int len = 1;
        int max = 1;
        char c = board[0][y];
        for (int i = 1; i < N; i++) {
            if (board[i][y] == c) {
                len++;
                max = Math.max(max, len);
            } else {
                len = 1;
                c = board[i][y];
            }
        }
        return max;
    }

    public static void checkSwap(int x, int y) {
        for (int i = 0; i < 2; i++) {
            int nr = x + dr[i];
            int nc = y + dc[i];

            if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                continue;
            }

            if (board[x][y] != board[nr][nc]) {
                swap(x, y, nr, nc);
                if (i == 0) {
                    ans = Math.max(ans, checkRow(x));
                    ans = Math.max(ans, checkRow(nr));
                    ans = Math.max(ans, checkCol(y));
                } else {
                    ans = Math.max(ans, checkCol(y));
                    ans = Math.max(ans, checkCol(nc));
                    ans = Math.max(ans, checkRow(x));
                }
                swap(x, y, nr, nc);
            }
        }
    }

    public static void swap(int x1, int y1, int x2, int y2) {
        char tmp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = tmp;
    }

}