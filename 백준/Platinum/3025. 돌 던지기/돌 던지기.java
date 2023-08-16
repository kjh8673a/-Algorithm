import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int R, C;
    static char[][] board;
    static Stack<Point>[] stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            String s = br.readLine();
            for (int j = 1; j <= C; j++) {
                board[i][j] = s.charAt(j - 1);
            }
        }

        stack = new Stack[C + 1];
        for (int i = 1; i <= C; i++) {
            stack[i] = new Stack<>();
        }

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int col = Integer.parseInt(br.readLine());

            while (!stack[col].isEmpty() &&
                    board[stack[col].peek().r][stack[col].peek().c] == 'O') {
                stack[col].pop();
            }

            if (stack[col].isEmpty()) {
                drop(1, col, col);
            } else {
                drop(stack[col].peek().r, stack[col].peek().c, col);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void drop(int r, int c, int col) {
        stack[col].push(new Point(r, c));

        // 돌의 아랫칸이 벽으로 막혀있거나 가장 아랫줄이라면, 돌은 그 자리에 그대로 멈춰 있는다.
        if (r + 1 <= R && board[r + 1][c] == 'X') {
            board[r][c] = 'O';
        } else if (r == R) {
            board[r][c] = 'O';
        }

        // 돌의 아랫칸이 비어있다면, 돌은 아랫칸으로 이동한다.
        else if (r + 1 <= R && board[r + 1][c] == '.') {
            drop(r + 1, c, col);
        }

        // 돌의 아랫칸에 돌이 있다면,
        else if (r + 1 <= R && board[r + 1][c] == 'O') {
            // 만약 돌의 왼쪽 칸과 왼쪽-아래 칸이 비어있다면, 돌은 왼쪽으로 미끄러진다.
            if (check(r, c - 1) && check(r + 1, c - 1) && board[r][c - 1] == '.' && board[r + 1][c - 1] == '.') {
                drop(r + 1, c - 1, col);
            }

            // 만약 돌이 왼쪽으로 미끄러지지 않았고, 오른쪽 칸과 오른쪽-아래 칸이 비어있다면, 돌은 오른쪽으로 미끄러진다.
            else if (check(r, c + 1) && check(r + 1, c + 1) && board[r][c + 1] == '.' && board[r + 1][c + 1] == '.') {
                drop(r + 1, c + 1, col);
            }

            // 위의 두 경우가 아니라면 돌은 그 자리에 멈추고, 다시는 움직이지 않는다.
            else {
                board[r][c] = 'O';
            }
        }
    }

    private static boolean check(int r, int c) {
        if (r < 1 || c < 1 || r > R || c > C) {
            return false;
        }
        return true;
    }

}