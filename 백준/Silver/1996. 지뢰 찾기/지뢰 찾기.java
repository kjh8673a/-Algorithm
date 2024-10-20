import java.io.*;

public class Main {
    static int[][] vector = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };
    
    static int n;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                char ch = line.charAt(j);
                if (ch == '.') {
                    board[i][j] = 0;
                } else {
                    board[i][j] = ch - '0';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] > 0) {
                    sb.append("*");
                } else {
                    int count = countMine(i, j);
                    if (count >= 10) {
                        sb.append("M");
                    } else {
                        sb.append(count);
                    }
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int countMine(int r, int c) {
        int result = 0;
        for (int k = 0; k < 8; k++) {
            int nr = r + vector[k][0];
            int nc = c + vector[k][1];

            if (nr < 0 || nc < 0 || nr >= n || nc >= n) {
                continue;
            }

            result += board[nr][nc];
        }

        return result;
    }

}