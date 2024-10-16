import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;

        board = new int[10][10];
        for (int i = 0; i < 10; i++) {
            String line = br.readLine();
            for (int j = 0; j < 10; j++) {
                char ch = line.charAt(j);
                if (ch == 'o') {
                    bomb(i, j);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == 0) {
                    answer = Math.min(answer, Math.abs(r - i) + Math.abs(c - j));
                }
            }
        }

        System.out.println(answer);
    }

    private static void bomb(int r, int c) {
        for (int i = 0; i < 10; i++) {
            board[r][i] = -1;
        }
        for (int i = 0; i < 10; i++) {
            board[i][c] = -1;
        }
    }

}
