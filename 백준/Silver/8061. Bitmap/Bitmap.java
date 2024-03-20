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

    static int[][] vector = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Node> queue = new LinkedList<>();
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                board[i][j] = line[j] - '0';
                if (board[i][j] == 1) {
                    queue.add(new Node(i, j));
                }
            }
        }

        int[][] result = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        int dist = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                if (visited[node.r][node.c]) {
                    continue;
                }
                result[node.r][node.c] = dist;
                visited[node.r][node.c] = true;

                for (int k = 0; k < 4; k++) {
                    int nr = node.r + vector[k][0];
                    int nc = node.c + vector[k][1];

                    if (nr < 0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc]) {
                        continue;
                    }

                    queue.add(new Node(nr, nc));
                }
            }

            dist++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(result[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}