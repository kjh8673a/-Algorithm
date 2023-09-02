import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node> {
        int r;
        int c;
        int dir;
        int cost;

        public Node(int r, int c, int dir, int cost) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static int[][] vector = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    static int w, h;
    static char[][] board;
    static Node start, end;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        board = new char[h][w];

        boolean flag = false;
        for (int i = 0; i < h; i++) {
            String s = br.readLine();
            for (int j = 0; j < w; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == 'C') {
                    if (!flag) {
                        start = new Node(i, j, -1, 0);
                        flag = true;
                    } else {
                        end = new Node(i, j, -1, 0);
                    }
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[][][] visit = new int[4][h][w];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < h; j++) {
                Arrays.fill(visit[i][j], Integer.MAX_VALUE);
            }
        }

        pq.add(start);

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.r == end.r && node.c == end.c) {
                return node.cost;
            }

            for (int i = 0; i < 4; i++) {
                int nr = node.r + vector[i][0];
                int nc = node.c + vector[i][1];

                if (nr < 0 || nc < 0 || nr >= h || nc >= w || board[nr][nc] == '*') {
                    continue;
                }

                if (node.dir != -1 && node.dir != i) {
                    if (visit[i][nr][nc] > node.cost + 1) {
                        visit[i][nr][nc] = node.cost + 1;
                        pq.add(new Node(nr, nc, i, node.cost + 1));
                    }
                } else {
                    if (visit[i][nr][nc] > node.cost) {
                        visit[i][nr][nc] = node.cost;
                        pq.add(new Node(nr, nc, i, node.cost));
                    }
                }
            }
        }

        return -1;
    }

}
