import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int turn = Integer.parseInt(br.readLine());
        int winner = 0;

        board = new int[3][3];
        StringTokenizer st;
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            board[r][c] = turn;
            if (winner == 0 && check(r, c, turn)) {
                winner = turn;
            }

            turn = turn == 2 ? 1 : 2;
        }

        System.out.println(winner);
    }

    private static boolean check(int r, int c, int turn) {
        if (board[r][0] == turn && board[r][1] == turn && board[r][2] == turn) {
            return true;
        }

        if (board[0][c] == turn && board[1][c] == turn && board[2][c] == turn) {
            return true;
        }

        if (board[0][0] == turn && board[1][1] == turn && board[2][2] == turn) {
            return true;
        }

        if (board[2][0] == turn && board[1][1] == turn && board[0][2] == turn) {
            return true;
        }

        return false;
    }

}