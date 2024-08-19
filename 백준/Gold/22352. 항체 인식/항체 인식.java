import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] before, after;

    static int[][] vector = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        before = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                before[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        after = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                after[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        loop: for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (before[i][j] != after[i][j]) {
                    injectVaccine(i, j, after[i][j]);
                    break loop;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (before[i][j] != after[i][j]) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");
    }

    private static void injectVaccine(int r, int c, int vac) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { r, c });

        List<int[]> list = new ArrayList<>();
        list.add(new int[] { r, c });

        boolean[][] visited = new boolean[n][m];
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nr = node[0] + vector[k][0];
                int nc = node[1] + vector[k][1];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                    continue;
                }

                if (visited[nr][nc]) {
                    continue;
                }

                if (before[nr][nc] != before[r][c]) {
                    continue;
                }

                queue.add(new int[] { nr, nc });
                list.add(new int[] { nr, nc });
                visited[nr][nc] = true;
            }
        }

        for (int[] node : list) {
            before[node[0]][node[1]] = vac;
        }
    }

}
