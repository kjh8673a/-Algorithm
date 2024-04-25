import java.io.*;
import java.util.*;

public class Main {
    static int[][] vector = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    static int n, m;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new char[n][m];
        int sr = 0;
        int sc = 0;
        int er = 0;
        int ec = 0;
        ArrayList<int[]> fishes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'S') {
                    sr = i;
                    sc = j;
                }
                if (board[i][j] == 'H') {
                    er = i;
                    ec = j;
                }
                if (board[i][j] == 'F') {
                    fishes.add(new int[] { i, j });
                }
            }
        }

        int[][] startToFish = bfs(sr, sc);
        int[][] endToFish = bfs(er, ec);

        int answer = Integer.MAX_VALUE;

        for (int[] fish : fishes) {
            int a = startToFish[fish[0]][fish[1]];
            int b = endToFish[fish[0]][fish[1]];
            if (a == 0 || b == 0) {
                continue;
            }
            answer = Math.min(answer, a + b);
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static int[][] bfs(int r, int c) {
        int[][] result = new int[n][m];

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        queue.add(new int[] { r, c });
        visited[r][c] = true;

        int time = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();

                for (int k = 0; k < 4; k++) {
                    int nr = node[0] + vector[k][0];
                    int nc = node[1] + vector[k][1];

                    if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                        continue;
                    }

                    if (board[nr][nc] == 'D' || visited[nr][nc]) {
                        continue;
                    }

                    visited[nr][nc] = true;
                    result[nr][nc] = time;
                    queue.add(new int[] { nr, nc });
                }
            }

            time++;
        }

        return result;
    }

}