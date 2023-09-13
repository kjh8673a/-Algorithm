import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int r;
        int c;
        int move;
        int key;

        public Node(int r, int c, int move, int key) {
            this.r = r;
            this.c = c;
            this.move = move;
            this.key = key;
        }
    }

    static int[][] vector = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[5][5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());

        System.out.println(bfs(sr, sc));
    }

    private static int bfs(int sr, int sc) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(sr, sc, 0, 1));

        boolean[][][] visit = new boolean[5][5][(1 << 7) - 1];
        visit[sr][sc][1] = true;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (Integer.bitCount(curr.key) == 7) {
                return curr.move;
            }

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + vector[i][0];
                int nc = curr.c + vector[i][1];

                if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5) {
                    continue;
                }

                if (visit[nr][nc][curr.key] || board[nr][nc] == -1) {
                    continue;
                }

                visit[nr][nc][curr.key] = true;
                queue.add(new Node(nr, nc, curr.move + 1, (curr.key | (1 << board[nr][nc]))));
            }
        }

        return -1;
    }

}
