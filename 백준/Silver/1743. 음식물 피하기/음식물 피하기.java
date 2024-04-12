import java.io.*;
import java.util.*;

public class Main {
    static int n, m, answer;
    static int[][] board;
    static boolean[][] visited;

    static int[][] vector = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r - 1][c - 1] = 1;
        }

        answer = 0;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { r, c });
        visited[r][c] = true;

        int cnt = 1;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nr = node[0] + vector[k][0];
                int nc = node[1] + vector[k][1];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                    continue;
                }

                if (visited[nr][nc] || board[nr][nc] == 0) {
                    continue;
                }

                cnt++;
                visited[nr][nc] = true;
                queue.add(new int[] { nr, nc });
            }
        }

        answer = Math.max(answer, cnt);
    }

}