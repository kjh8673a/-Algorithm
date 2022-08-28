import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] board;
    static int direction, nowX, nowY;
    static int n, m;
    static int ansX, ansY;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        board = new int[n][n];

        int start = n * n;

        direction = 1;

        nowX = 0;
        nowY = 0;

        ansX = 0;
        ansY = 0;

        for (int i = start; i > 0; i--) {
            snail(i);

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j] + " ");
            }
            sb.append("\n");
        }

        sb.append(ansX + " " + ansY);

        System.out.println(sb.toString());

    }

    public static void snail(int num) {
        board[nowX][nowY] = num;

        if (num == m) {
            ansX = nowX + 1;
            ansY = nowY + 1;
        }
        if (num == 1)
            return;

        switch (direction) {
            case 1:
                if (nowX + 1 >= n || board[nowX + 1][nowY] != 0) {
                    direction = 2;
                    nowY++;
                    break;
                }
                nowX++;
                break;

            case 2:
                if (nowY + 1 >= n || board[nowX][nowY + 1] != 0) {
                    direction = 3;
                    nowX--;
                    break;
                }
                nowY++;
                break;

            case 3:
                if (nowX - 1 < 0 || board[nowX - 1][nowY] != 0) {
                    direction = 4;
                    nowY--;
                    break;
                }
                nowX--;
                break;

            case 4:
                if (nowY - 1 < 0 || board[nowX][nowY - 1] != 0) {
                    direction = 1;
                    nowX++;
                    break;
                }
                nowY--;
                break;
        }
    }

}