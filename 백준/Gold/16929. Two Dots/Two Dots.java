import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] board;
    static boolean[][] visited;
    static boolean cycle;

    static int[][] vector = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

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

        visited = new boolean[n][m];
        cycle = false;
        loop: for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (cycle) {
                    break loop;
                }
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    dfs(i, j, i, j, 1);
                }
            }
        }

        System.out.println(cycle ? "Yes" : "No");
    }

    private static void dfs(int sr, int sc, int r, int c, int cnt) {
        if (cycle) {
            return;
        }

        for (int k = 0; k < 4; k++) {
            int nr = r + vector[k][0];
            int nc = c + vector[k][1];

            if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                continue;
            }

            if (board[r][c] != board[nr][nc]) {
                continue;
            }

            if (visited[nr][nc] && cnt > 2 && nr == sr && nc == sc) {
                cycle = true;
                return;
            }

            if (!visited[nr][nc]) {
                visited[nr][nc] = true;
                dfs(sr, sc, nr, nc, cnt + 1);
                visited[nr][nc] = false;
            }
        }
    }

}