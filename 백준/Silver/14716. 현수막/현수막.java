import java.io.*;
import java.util.*;

public class Main {
    static int m, n;
    static int[][] banner;
    static int[][] vector = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        banner = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                banner[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (banner[i][j] > 0) {
                    dfs(i, j);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    private static void dfs(int r, int c) {
        banner[r][c] = 0;
        for (int k = 0; k < 8; k++) {
            int nr = r + vector[k][0];
            int nc = c + vector[k][1];

            if (nr < 0 || nc < 0 || nr >= m || nc >= n || banner[nr][nc] != 1) {
                continue;
            }

            dfs(nr, nc);
        }
    }

}