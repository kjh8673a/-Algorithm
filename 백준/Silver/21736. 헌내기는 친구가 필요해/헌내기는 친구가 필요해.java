import java.io.*;
import java.util.*;

public class Main {
    static int[][] vector = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    static int n, m;
    static char[][] campus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        campus = new char[n][m];

        int[] doyeon = new int[2];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                campus[i][j] = line.charAt(j);
                if (campus[i][j] == 'I') {
                    doyeon[0] = i;
                    doyeon[1] = j;
                }
            }
        }

        int answer = bfs(doyeon);

        System.out.println(answer == 0 ? "TT" : answer);
    }

    private static int bfs(int[] doyeon) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(doyeon);

        boolean[][] visited = new boolean[n][m];
        visited[doyeon[0]][doyeon[1]] = true;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            if (campus[node[0]][node[1]] == 'P') {
                count++;
            }

            for (int k = 0; k < 4; k++) {
                int nr = node[0] + vector[k][0];
                int nc = node[1] + vector[k][1];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc] || campus[nr][nc] == 'X') {
                    continue;
                }

                queue.add(new int[] { nr, nc });
                visited[nr][nc] = true;
            }
        }

        return count;
    }

}