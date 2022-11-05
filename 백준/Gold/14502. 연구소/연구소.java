import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };
    static int N, M, ans;
    static boolean[] sel;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 0;
        sel = new boolean[N * M];
        permutation(0, 0);

        System.out.println(ans);

    }

    public static void permutation(int cnt, int idx) {
        if (cnt == 3) {
            for (int i = 0; i < sel.length; i++) {
                if (sel[i]) {
                    if (map[i / M][i % M] != 0) {
                        return;
                    }
                }
            }
            bfs();
            return;
        }

        for (int i = idx; i < sel.length; i++) {
            sel[i] = true;
            permutation(cnt + 1, i + 1);
            sel[i] = false;
        }
    }

    public static void bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = map[i][j];
                if (tmp[i][j] == 2) {
                    queue.add(new Node(i, j));
                }
            }
        }

        for (int i = 0; i < sel.length; i++) {
            if (sel[i]) {
                tmp[i / M][i % M] = 1;
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int r = node.r;
            int c = node.c;

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    continue;
                }

                if (tmp[nr][nc] != 0) {
                    continue;
                }

                tmp[nr][nc] = 2;
                queue.add(new Node(nr, nc));
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmp[i][j] == 0) {
                    cnt++;
                }
            }
        }

        ans = Math.max(ans, cnt);

    }

}