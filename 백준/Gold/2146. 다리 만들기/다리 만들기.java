import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r;
        int c;
        int dist;

        public Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }

    static int N, ans;
    static int[][] map;
    static boolean[][] visit;

    static int[][] vector = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int idx = 2;
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    colorIsland(i, j, idx++);
                }
            }
        }

        ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) {
                    visit = new boolean[N][N];
                    bfs(i, j, map[i][j]);
                }
            }
        }

        System.out.println(ans);
    }

    private static void bfs(int r, int c, int num) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(r, c, 0));
        visit[r][c] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int j = 0; j < 4; j++) {
                int nr = node.r + vector[j][0];
                int nc = node.c + vector[j][1];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N || visit[nr][nc]) {
                    continue;
                }

                if (map[nr][nc] == 0) {
                    visit[nr][nc] = true;
                    queue.add(new Node(nr, nc, node.dist + 1));
                } else if (map[nr][nc] != num) {
                    ans = Math.min(ans, node.dist);
                }
            }
        }
    }

    private static void colorIsland(int r, int c, int num) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(r, c, 0));
        visit[r][c] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            map[node.r][node.c] = num;

            for (int i = 0; i < 4; i++) {
                int nr = node.r + vector[i][0];
                int nc = node.c + vector[i][1];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] != 1) {
                    continue;
                }

                if (!visit[nr][nc]) {
                    visit[nr][nc] = true;
                    queue.add(new Node(nr, nc, 0));
                }
            }
        }
    }

}
