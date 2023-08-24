import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[][] vector = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 3, 0 }, { -3, 0 }, { 0, 3 }, { 0, -3 },
            { 2, 1 }, { -2, 1 }, { 1, 2 }, { 1, -2 }, { 2, -1 }, { -2, -1 }, { -1, 2 }, { -1, -2 } };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] field = new int[N][N];
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;

        int ans = Integer.MAX_VALUE;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int remain = Math.abs(N - 1 - node.r) + Math.abs(N - 1 - node.c);
            if (remain <= 2) {
                ans = Math.min(ans, dist[node.r][node.c] + remain * T);
            }

            for (int i = 0; i < 16; i++) {
                int nr = node.r + vector[i][0];
                int nc = node.c + vector[i][1];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
                    continue;
                }

                if (dist[nr][nc] > dist[node.r][node.c] + field[nr][nc] + 3 * T) {
                    dist[nr][nc] = dist[node.r][node.c] + field[nr][nc] + 3 * T;
                    queue.add(new Node(nr, nc));
                }
            }
        }

        System.out.println(ans);
    }

}