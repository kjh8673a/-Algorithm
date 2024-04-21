import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[][] vector = { { -1, 1 }, { 0, 1 }, { 1, 1 } };

    static int n, m, answer;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        answer = 0;
        for (int i = 0; i < n; i++) {
            dfs(i, 0);
        }

        System.out.println(answer);
    }

    private static boolean dfs(int r, int c) {
        if (c == m - 1) {
            answer++;
            return true;
        }

        for (int k = 0; k < 3; k++) {
            int nr = r + vector[k][0];
            int nc = c + vector[k][1];

            if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                continue;
            }

            if (board[nr][nc] == '.') {
                board[nr][nc] = 'o';
                if (dfs(nr, nc)) {
                    return true;
                }
            }
        }

        return false;
    }

}