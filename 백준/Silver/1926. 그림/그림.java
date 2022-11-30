import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = { 1, -1, 0, 0 };
    static int[] dc = { 0, 0, 1, -1 };
    static int[][] board;
    static int n, m, cnt, ans, area;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt = 0;
        ans = 0;
        area = 0;

        for (int i = 0; i < n * m; i++) {
            int r = i / m;
            int c = i % m;

            if (board[r][c] == 1) {
                area = 0;
                cnt++;
                dfs(r, c);
                ans = Math.max(ans, area);
            }
        }

        System.out.println(cnt);
        System.out.println(ans);

    }

    public static void dfs(int r, int c) {
        area++;
        board[r][c] = -1;

        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];

            if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                continue;
            }

            if (board[nr][nc] == 1) {
                dfs(nr, nc);
            }
        }
    }

}