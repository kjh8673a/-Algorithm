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

    static int N, M, K;
    static int[][] arr;
    static int[][] vector = { { 1, 0 }, { 0, 1 } };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        bfs();

        StringBuilder sb = new StringBuilder();
        if (arr[N - 1][M - 1] == 0) {
            sb.append("NO").append("\n");
        } else {
            sb.append("YES").append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    sb.append(arr[i][j] + " ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));

        boolean[][] visit = new boolean[N][M];
        visit[0][0] = true;

        int num = 1;
        while (!queue.isEmpty()) {
            if (num > K) {
                return;
            }

            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                arr[node.r][node.c] = num;

                for (int k = 0; k < 2; k++) {
                    int nr = node.r + vector[k][0];
                    int nc = node.c + vector[k][1];

                    if (nr < 0 || nc < 0 || nr >= N || nc >= M || visit[nr][nc]) {
                        continue;
                    }

                    visit[nr][nc] = true;
                    queue.add(new Node(nr, nc));
                }
            }

            num++;
        }

    }

}