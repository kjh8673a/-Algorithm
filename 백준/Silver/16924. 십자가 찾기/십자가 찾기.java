import java.io.*;
import java.util.*;

public class Main {
    static class Cross {
        int r;
        int c;
        int len;

        public Cross(int r, int c, int len) {
            this.r = r;
            this.c = c;
            this.len = len;
        }
    }

    static int n, m;
    static char[][] board;
    static ArrayList<Cross> cross;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n + 1][m + 1];
        int star = 0;
        for (int i = 1; i < n + 1; i++) {
            String line = br.readLine();
            for (int j = 1; j < m + 1; j++) {
                board[i][j] = line.charAt(j - 1);
                if (board[i][j] == '*') {
                    star++;
                }
            }
        }

        cross = findCross();
        int cnt = colorBoard();

        StringBuilder sb = new StringBuilder();
        if (star == cnt) {
            sb.append(cross.size()).append("\n");
            for (Cross c : cross) {
                sb.append(c.r + " " + c.c + " " + c.len).append("\n");
            }
        } else {
            sb.append("-1");
        }

        System.out.println(sb);
    }

    private static int colorBoard() {
        int result = 0;
        for (Cross c : cross) {
            for (int i = 0; i <= c.len; i++) {
                if (board[c.r - i][c.c] == '*') {
                    board[c.r - i][c.c] = '.';
                    result++;
                }
                if (board[c.r][c.c - i] == '*') {
                    board[c.r][c.c - i] = '.';
                    result++;
                }
                if (board[c.r + i][c.c] == '*') {
                    board[c.r + i][c.c] = '.';
                    result++;
                }
                if (board[c.r][c.c + i] == '*') {
                    board[c.r][c.c + i] = '.';
                    result++;
                }
            }
        }

        return result;
    }

    private static ArrayList<Cross> findCross() {
        ArrayList<Cross> result = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (board[i][j] == '*') {
                    int len = 1;
                    while (i - len >= 1 && j - len >= 1 && i + len < n + 1 && j + len < m + 1) {
                        if (board[i - len][j] == '*' && board[i][j - len] == '*' && board[i + len][j] == '*'
                                && board[i][j + len] == '*') {
                            result.add(new Cross(i, j, len));
                        } else {
                            break;
                        }
                        len++;
                    }
                }
            }
        }

        return result;
    }

}