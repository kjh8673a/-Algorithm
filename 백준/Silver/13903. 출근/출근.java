import java.io.*;
import java.util.*;

public class Main {
    static int r, c, n, answer;
    static int[][] board, vector;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        n = Integer.parseInt(br.readLine());
        vector = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            vector[i][0] = Integer.parseInt(st.nextToken());
            vector[i][1] = Integer.parseInt(st.nextToken());
        }

        answer = -1;
        bfs();

        System.out.println(answer);
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[r][c];
        for (int i = 0; i < c; i++) {
            if (board[0][i] == 1) {
                queue.add(new int[] { 0, i });
                visited[0][i] = true;
            }
        }

        int depth = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] node = queue.poll();

                if (node[0] == r - 1) {
                    answer = depth;
                    return;
                }
                for (int j = 0; j < n; j++) {
                    int nr = node[0] + vector[j][0];
                    int nc = node[1] + vector[j][1];

                    if (nr < 0 || nc < 0 || nr >= r || nc >= c || visited[nr][nc]) {
                        continue;
                    }

                    if (board[nr][nc] == 0) {
                        continue;
                    }

                    queue.add(new int[] { nr, nc });
                    visited[nr][nc] = true;
                }
            }

            depth++;
        }
    }

}