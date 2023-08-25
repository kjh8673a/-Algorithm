import java.io.*;

public class Main {
    static int[][] board;
    static boolean error = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String s = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = s.charAt(j) == '.' ? 0 : s.charAt(j) - '0';
            }
        }

        while (true) {
            if (!play()) {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (error) {
            sb.append("ERROR");
        } else {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j] == 0 ? "." : board[i][j]);
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean play() {
        for (int i = 1; i <= 9; i++) {
            if (crossHatching(i)) {
                return true;
            }
        }
        return false;
    }

    static boolean[] row, col;
    static boolean[][] box;

    private static boolean crossHatching(int x) {
        row = new boolean[9];
        col = new boolean[9];
        box = new boolean[3][3];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == x) {
                    if (row[i] || col[j] || box[i / 3][j / 3]) {
                        error = true;
                        return false;
                    }

                    row[i] = true;
                    col[j] = true;
                    box[i / 3][j / 3] = true;
                }
            }
        }

        boolean flag = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!box[i][j]) {
                    if (check(i * 3, j * 3, x)) {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    private static boolean check(int sr, int sc, int x) {
        int nr = -1;
        int nc = -1;
        int cnt = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + sr][j + sc] == 0 && !row[i + sr] && !col[j + sc]) {
                    if (cnt == 0) {
                        nr = i + sr;
                        nc = j + sc;
                        cnt++;
                    } else {
                        return false;
                    }
                }
            }
        }

        if (cnt == 0) {
            error = true;
            return false;
        }

        board[nr][nc] = x;
        row[nr] = true;
        col[nc] = true;

        return true;
    }

}