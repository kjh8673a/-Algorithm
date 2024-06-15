import java.io.*;
import java.util.*;

public class Main {
    static int r, c;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int answer = jump(0, 0);

        System.out.println(answer);
    }

    private static int jump(int a, int b) {
        if (a == r - 1 && b == c - 1) {
            return 1;
        }

        char type = board[a][b];
        int result = 0;
        for (int i = a + 1; i < r; i++) {
            for (int j = b + 1; j < c; j++) {
                if (type != board[i][j]) {
                    result += jump(i, j);
                }
            }
        }

        return result;
    }

}