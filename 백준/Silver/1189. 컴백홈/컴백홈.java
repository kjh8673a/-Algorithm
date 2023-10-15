import java.util.*;
import java.io.*;

public class Main {
    static int[][] vector = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    static int R, C, K, ans = 0;
    static char[][] board;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        visit = new boolean[R][C];
        visit[R - 1][0] = true;
        dfs(R - 1, 0, 1);

        System.out.println(ans);
    }

    private static void dfs(int r, int c, int cnt) {
        if (r == 0 && c == C - 1) {
            if (cnt == K) {
                ans++;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + vector[i][0];
            int nc = c + vector[i][1];

            if (!isPossible(nr, nc)) {
                continue;
            }

            visit[nr][nc] = true;
            dfs(nr, nc, cnt + 1);
            visit[nr][nc] = false;
        }

    }

    private static boolean isPossible(int nr, int nc) {
        if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
            return false;
        }

        if (board[nr][nc] == 'T' || visit[nr][nc]) {
            return false;
        }

        return true;
    }

}
