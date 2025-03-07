import java.io.*;
import java.util.*;

public class Main {
    static int[][] vector = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] maze = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                if (line.charAt(j) == '1') {
                    maze[i][j] = true;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0 });

        int depth = 1;
        loop: while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                int[] node = queue.poll();

                if (node[0] == n - 1 && node[1] == m - 1) {
                    break loop;
                }

                for (int k = 0; k < 4; k++) {
                    int nr = node[0] + vector[k][0];
                    int nc = node[1] + vector[k][1];

                    if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                        continue;
                    }

                    if (!maze[nr][nc]) {
                        continue;
                    }

                    maze[nr][nc] = false;
                    queue.add(new int[] { nr, nc });
                }
            }

            depth++;
        }

        System.out.println(depth);
    }
}