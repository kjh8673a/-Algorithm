import java.io.*;
import java.util.*;

public class Main {
    static char[][] board;
    static Set<Character> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new char[4][10];
        for (int i = 0; i < 4; i++) {
            board[i] = br.readLine().toCharArray();
        }

        set = new HashSet<>();
        String line = br.readLine();
        for (int i = 0; i < 9; i++) {
            set.add(line.charAt(i));
        }

        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < 9; j++) {
                if (!set.contains(board[i][j])) {
                    continue;
                }

                if (checkAround(i, j)) {
                    System.out.println(board[i][j]);
                    return;
                }
            }
        }
    }

    private static boolean checkAround(int i, int j) {
        if (!set.contains(board[i - 1][j - 1])) {
            return false;
        }
        if (!set.contains(board[i - 1][j])) {
            return false;
        }
        if (!set.contains(board[i - 1][j + 1])) {
            return false;
        }
        if (!set.contains(board[i][j - 1])) {
            return false;
        }
        if (!set.contains(board[i][j + 1])) {
            return false;
        }
        if (!set.contains(board[i + 1][j - 1])) {
            return false;
        }
        if (!set.contains(board[i + 1][j])) {
            return false;
        }
        if (!set.contains(board[i + 1][j + 1])) {
            return false;
        }

        return true;
    }
}