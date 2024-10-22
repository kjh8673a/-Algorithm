import java.io.*;
import java.util.*;

public class Main {
    static class Corn implements Comparable<Corn> {
        int r;
        int c;
        int value;

        public Corn(int r, int c, int value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }

        @Override
        public int compareTo(Corn o) {
            return Integer.compare(o.value, this.value);
        }
    }

    static int[][] vector = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Corn> pq = new PriorityQueue<>();
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    pq.add(new Corn(i, j, board[i][j]));
                    board[i][j] = 0;
                }
            }
        }

        int k = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (k-- > 0) {
            Corn node = pq.poll();
            sb.append((node.r + 1) + " " + (node.c + 1)).append("\n");

            for (int i = 0; i < 4; i++) {
                int nr = node.r + vector[i][0];
                int nc = node.c + vector[i][1];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) {
                    continue;
                }

                if (board[nr][nc] == 0) {
                    continue;
                }

                pq.add(new Corn(nr, nc, board[nr][nc]));
                board[nr][nc] = 0;
            }
        }

        System.out.println(sb);
    }

}