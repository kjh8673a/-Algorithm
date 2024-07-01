import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] flag_a, flag_b;
    static boolean[][] visited;
    static int[][] vector = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        flag_a = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                flag_a[i][j] = line.charAt(j);
            }
        }

        flag_b = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                flag_b[i][j] = line.charAt(j);
            }
        }

        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) {
                    if (flag_a[i][j] != flag_b[i][j]) {
                        System.out.println("NO");
                        return;
                    }
                } else {
                    bfs(i, j, flag_a[i][j], flag_b[i][j]);
                }
            }
        }

        System.out.println("YES");
    }

    private static void bfs(int r, int c, char from, char to) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { r, c });

        visited[r][c] = true;
        flag_a[r][c] = to;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nr = node[0] + vector[k][0];
                int nc = node[1] + vector[k][1];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc]) {
                    continue;
                }

                if (flag_a[nr][nc] != from) {
                    continue;
                }

                flag_a[nr][nc] = to;
                visited[nr][nc] = true;
                queue.add(new int[] { nr, nc });
            }
        }
    }

}