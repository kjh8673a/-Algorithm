import java.io.*;
import java.util.*;

public class Main {
    static int[][] vector = { { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, 1 }, { 0, -1 }, { -1, 1 }, { -1, 0 }, { -1, -1 } };

    static int n, m;
    static int[][] farm;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        farm = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                farm[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    answer += bfs(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    private static int bfs(int r, int c) {
        int result = 1;
        int height = farm[r][c];
        boolean[][] visitedNow = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        visited[r][c] = true;
        visitedNow[r][c] = true;
        queue.add(new int[] { r, c });

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            for (int k = 0; k < 8; k++) {
                int nr = node[0] + vector[k][0];
                int nc = node[1] + vector[k][1];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                    continue;
                }

                if (farm[nr][nc] > height) {
                    result = 0;
                } else if (farm[nr][nc] == height && !visitedNow[nr][nc]) {
                    queue.add(new int[] { nr, nc });
                    visited[nr][nc] = true;
                    visitedNow[nr][nc] = true;
                } else {
                    visited[nr][nc] = true;
                    visitedNow[nr][nc] = true;
                }
            }
        }

        return result;
    }

}