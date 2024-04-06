import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[9][9];
        StringTokenizer st;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
    }

    private static void dfs(int r, int c) {
        if (c == 9) {
            dfs(r + 1, 0);
            return;
        }

        if (r == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j] + " ");
                }
                sb.append("\n");
            }

            System.out.println(sb);

            System.exit(0);
        }

        if (board[r][c] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (check(r, c, i)) {
                    board[r][c] = i;
                    dfs(r, c + 1);
                }
            }
            board[r][c] = 0;
            return;
        }

        dfs(r, c + 1);
    }

    private static boolean check(int r, int c, int num) {
        if (!checkRow(r, c, num)) {
            return false;
        }

        if (!checkCol(r, c, num)) {
            return false;
        }

        if (!checkBox(r, c, num)) {
            return false;
        }

        return true;
    }

    private static boolean checkBox(int r, int c, int num) {
        int sr = (r / 3) * 3;
        int sc = (c / 3) * 3;
        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean checkCol(int r, int c, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[i][c] == num) {
                return false;
            }
        }

        return true;
    }

    private static boolean checkRow(int r, int c, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == num) {
                return false;
            }
        }

        return true;
    }

}