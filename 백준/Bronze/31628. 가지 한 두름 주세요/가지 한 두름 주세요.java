import java.io.*;
import java.util.*;

public class Main {
    static String[][] board;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new String[10][10];
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                board[i][j] = st.nextToken();
            }
        }

        flag = false;
        checkRow();
        checkCol();

        System.out.println(flag ? 1 : 0);
    }

    private static void checkCol() {
        if (flag) {
            return;
        }

        loop: for (int i = 0; i < 10; i++) {
            String color = board[0][i];
            for (int j = 1; j < 10; j++) {
                if (!color.equals(board[j][i])) {
                    continue loop;
                }
            }

            flag = true;
            return;
        }
    }

    private static void checkRow() {
        if (flag) {
            return;
        }

        loop: for (int i = 0; i < 10; i++) {
            String color = board[i][0];
            for (int j = 1; j < 10; j++) {
                if (!color.equals(board[i][j])) {
                    continue loop;
                }
            }

            flag = true;
            return;
        }
    }
}