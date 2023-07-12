import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int n, m;
    static int[][] map, result;
    static Queue<Node> queue = new LinkedList<>();

    static int[][] vector = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        result = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(result[i], -1);
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    queue.add(new Node(i, j));
                    result[i][j] = 0;
                }
                if (map[i][j] == 0) {
                    result[i][j] = 0;
                }
            }
        }

        bfs();
    }

    private static void bfs() {
        Node start = queue.peek();
        result[start.r][start.c] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int dist = result[node.r][node.c];

            for (int i = 0; i < 4; i++) {
                int nr = node.r + vector[i][0];
                int nc = node.c + vector[i][1];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m || result[nr][nc] != -1) {
                    continue;
                }

                if (map[nr][nc] == 1) {
                    result[nr][nc] = dist + 1;
                    queue.add(new Node(nr, nc));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
