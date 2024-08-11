import java.io.*;
import java.util.*;

public class Main {
    static char[][] board;
    static int[][] vector = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] logs = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            logs[i][0] = Integer.parseInt(st.nextToken());
            logs[i][1] = Integer.parseInt(st.nextToken());
        }

        board = new char[7][7];
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                board[i][j] = '.';
            }
        }
        board[3][3] = 'W';
        board[4][4] = 'W';
        board[3][4] = 'B';
        board[4][3] = 'B';

        for (int i = 0; i < n; i++) {
            int r = logs[i][0];
            int c = logs[i][1];

            putStone(r, c, i);
        }

        int black = 0;
        int white = 0;
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                System.out.print(board[i][j]);
                if (board[i][j] == 'B') {
                    black++;
                } else if (board[i][j] == 'W') {
                    white++;
                }
            }
            System.out.println();
        }

        System.out.println(black > white ? "Black" : "White");
    }

    private static void putStone(int r, int c, int turn) {
        if (turn % 2 == 0) {
            board[r][c] = 'B';
        } else {
            board[r][c] = 'W';
        }

        loop: for (int k = 0; k < 8; k++) {
            ArrayList<int[]> toBeChanged = new ArrayList<>();
            int nr = r;
            int nc = c;
            while (true) {
                nr += vector[k][0];
                nc += vector[k][1];

                if (nr < 1 || nc < 1 || nr > 6 || nc > 6) {
                    continue loop;
                }

                if (board[nr][nc] == board[r][c]) {
                    break;
                } else if (board[nr][nc] == '.') {
                    continue loop;
                } else {
                    toBeChanged.add(new int[] { nr, nc });
                }
            }

            for (int[] spot : toBeChanged) {
                board[spot[0]][spot[1]] = board[r][c];
            }
        }
    }

}