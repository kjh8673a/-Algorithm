import java.io.*;
import java.util.*;

public class Main {
    static int n, max, x, y;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                if (line.charAt(j) == 'B') {
                    board[i][j] = 1;
                } else if (line.charAt(j) == 'W') {
                    board[i][j] = -1;
                }
            }
        }

        max = 0;
        x = 0;
        y = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    putStone(i, j);
                }
            }
        }

        if (max == 0) {
            System.out.println("PASS");
        } else {
            System.out.println(x + " " + y);
            System.out.println(max);
        }
    }

    private static void putStone(int i, int j) {
        int count = 0;

        count += cal(i, j, -1, 0);
        count += cal(i, j, 1, 0);
        count += cal(i, j, 0, -1);
        count += cal(i, j, 0, 1);
        count += cal(i, j, -1, -1);
        count += cal(i, j, 1, 1);
        count += cal(i, j, 1, -1);
        count += cal(i, j, -1, 1);

        if (max < count) {
            max = count;
            x = j;
            y = i;
        }
    }

    private static int cal(int r, int c, int dr, int dc) {
        int count = 0;
        while (true) {
            r += dr;
            c += dc;

            if (r < 0 || c < 0 || r >= n || c >= n) {
                break;
            }

            if (board[r][c] == -1) {
                count++;
            } else {
                if (board[r][c] == 1) {
                    return count;
                }
                break;
            }
        }

        return 0;
    }

}