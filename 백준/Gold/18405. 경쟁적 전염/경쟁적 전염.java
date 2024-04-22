import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int num;
        int r;
        int c;

        public Node(int num, int r, int c) {
            this.num = num;
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Node o) {
            return this.num - o.num;
        }

    }

    static int n, k;
    static int[][] board;
    static PriorityQueue<Node> pq;

    static int[][] vector = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] > 0) {
                    pq.add(new Node(board[i][j], i, j));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;

        bfs(s);

        System.out.println(board[x][y]);
    }

    private static void bfs(int s) {
        int depth = 0;
        while (depth++ < s) {
            int size = pq.size();

            PriorityQueue<Node> tmp = new PriorityQueue<>();
            for (int i = 0; i < size; i++) {
                Node node = pq.poll();

                for (int k = 0; k < 4; k++) {
                    int nr = node.r + vector[k][0];
                    int nc = node.c + vector[k][1];

                    if (nr < 0 || nc < 0 || nr >= n || nc >= n) {
                        continue;
                    }

                    if (board[nr][nc] == 0) {
                        board[nr][nc] = node.num;
                        tmp.add(new Node(node.num, nr, nc));
                    }
                }
            }

            pq.addAll(tmp);
        }
    }

}