import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r;
        int c;
        int time;
        boolean weapon;

        public Node(int r, int c, int time, boolean weapon) {
            this.r = r;
            this.c = c;
            this.time = time;
            this.weapon = weapon;
        }
    }

    static int[][] vector = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    static int N, M, T;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    private static String bfs() {
        Queue<Node> queue = new LinkedList<>();
        boolean[][][] visit = new boolean[N][M][2];
        queue.add(new Node(0, 0, 0, false));
        visit[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.r == N - 1 && node.c == M - 1) {
                return String.valueOf(node.time);
            }

            if (node.time == T) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nr = node.r + vector[i][0];
                int nc = node.c + vector[i][1];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    continue;
                }

                if (node.weapon) {
                    if (visit[nr][nc][1]) {
                        continue;
                    } else {
                        queue.add(new Node(nr, nc, node.time + 1, true));
                        visit[nr][nc][1] = true;
                    }
                } else {
                    if (visit[nr][nc][0] || board[nr][nc] == 1) {
                        continue;
                    } else if (board[nr][nc] == 2) {
                        queue.add(new Node(nr, nc, node.time + 1, true));
                        visit[nr][nc][0] = true;
                        visit[nr][nc][1] = true;
                    } else {
                        queue.add(new Node(nr, nc, node.time + 1, false));
                        visit[nr][nc][0] = true;
                    }
                }
            }
        }

        return "Fail";
    }

}
