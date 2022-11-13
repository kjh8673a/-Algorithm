import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

    }

    static int N, cnt_a, cnt_b;
    static Character[][] map;
    static boolean[][][] visit;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new Character[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        visit = new boolean[N][N][2];
        cnt_a = 0;
        cnt_b = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j][0]) {
                    bfs(i, j, 0);
                    cnt_a++;
                }

                if (!visit[i][j][1]) {
                    bfs(i, j, 1);
                    cnt_b++;
                }
            }
        }

        System.out.println(cnt_a + " " + cnt_b);
    }

    public static void bfs(int r, int c, int type) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(r, c));
        visit[r][c][type] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            char color = map[node.r][node.c];

            for (int k = 0; k < 4; k++) {
                int nr = node.r + dr[k];
                int nc = node.c + dc[k];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                    continue;
                }

                if (visit[nr][nc][type]) {
                    continue;
                }

                switch (type) {
                    case 0:
                        if (map[nr][nc] == color) {
                            queue.add(new Node(nr, nc));
                            visit[nr][nc][type] = true;
                        }
                        break;

                    case 1:
                        if (color == 'B') {
                            if (map[nr][nc] == color) {
                                queue.add(new Node(nr, nc));
                                visit[nr][nc][type] = true;
                            }
                        } else {
                            if (map[nr][nc] == 'R' || map[nr][nc] == 'G') {
                                queue.add(new Node(nr, nc));
                                visit[nr][nc][type] = true;
                            }
                        }
                        break;
                }
            }
        }
    }
}