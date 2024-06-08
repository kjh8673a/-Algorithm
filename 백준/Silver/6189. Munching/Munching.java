import java.io.*;
import java.util.*;

public class Main {
    static int[][] vector = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] board = new char[r][c];
        int sr = 0;
        int sc = 0;
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'C') {
                    sr = i;
                    sc = j;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[r][c];

        queue.add(new int[] { sr, sc });
        visited[sr][sc] = true;

        int answer = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] node = queue.poll();
                if (board[node[0]][node[1]] == 'B') {
                    System.out.println(answer);
                    return;
                }

                for (int k = 0; k < 4; k++) {
                    int nr = node[0] + vector[k][0];
                    int nc = node[1] + vector[k][1];

                    if (nr < 0 || nc < 0 || nr >= r || nc >= c) {
                        continue;
                    }

                    if (visited[nr][nc] || board[nr][nc] == '*') {
                        continue;
                    }

                    visited[nr][nc] = true;
                    queue.add(new int[] { nr, nc });
                }

            }
            answer++;
        }

    }

}