import java.io.*;
import java.util.*;

public class Main {
    static int n, m, w, b;
    static char[][] board;
    static boolean[][] visited;

    static int[][] vector = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        visited = new boolean[n][m];
        w = 0;
        b = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(w + " " + b);
    }

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { i, j });
        visited[i][j] = true;

        int cnt = 1;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nr = node[0] + vector[k][0];
                int nc = node[1] + vector[k][1];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                    continue;
                }

                if (visited[nr][nc] || board[nr][nc] != board[i][j]) {
                    continue;
                }

                visited[nr][nc] = true;
                cnt++;
                queue.add(new int[] { nr, nc });
            }
        }

        if (board[i][j] == 'W') {
            w += cnt * cnt;
        } else {
            b += cnt * cnt;
        }
    }

}