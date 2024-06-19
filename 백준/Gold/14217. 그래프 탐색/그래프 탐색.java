import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] city;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        city = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            city[a][b] = 1;
            city[b][a] = 1;
        }

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 1) {
                city[b][c] = 1;
                city[c][b] = 1;
            } else {
                city[b][c] = 0;
                city[c][b] = 0;
            }

            bfs();
        }

        System.out.println(sb);
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        int[] result = new int[n + 1];
        Arrays.fill(result, -1);
        result[1] = 0;

        int depth = 1;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int node = queue.poll();

                for (int j = 1; j < n + 1; j++) {
                    if (city[node][j] == 1 && !visited[j]) {
                        queue.add(j);
                        visited[j] = true;
                        result[j] = depth;
                    }
                }
            }
            depth++;
        }

        for (int i = 1; i < n + 1; i++) {
            sb.append(result[i] + " ");
        }
        sb.append("\n");
    }
}