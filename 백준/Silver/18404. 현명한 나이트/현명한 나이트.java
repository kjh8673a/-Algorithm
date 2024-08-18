import java.io.*;
import java.util.*;

public class Main {
    static int n, m, x, y;
    static Map<String, Integer> enemies;
    static int[] answer;

    static int[][] vector = { { -2, -1 }, { -2, 1 }, { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2 }, { 2, -1 }, { 2, 1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        enemies = new HashMap<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            enemies.put(a + ":" + b, i);
        }

        answer = new int[m];
        bfs();

        StringBuilder sb = new StringBuilder();
        Arrays.stream(answer).forEach(m -> sb.append(m + " "));

        System.out.println(sb);
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { x, y });

        boolean[][] visited = new boolean[n + 1][n + 1];
        visited[x][y] = true;

        int count = enemies.size();
        int move = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int[] node = queue.poll();

                if (enemies.containsKey(node[0] + ":" + node[1])) {
                    answer[enemies.get(node[0] + ":" + node[1])] = move;
                    count--;
                    if (count == 0) {
                        return;
                    }
                }

                for (int k = 0; k < 8; k++) {
                    int nr = node[0] + vector[k][0];
                    int nc = node[1] + vector[k][1];

                    if (nr < 1 || nc < 1 || nr > n || nc > n) {
                        continue;
                    }

                    if (visited[nr][nc]) {
                        continue;
                    }

                    queue.add(new int[] { nr, nc });
                    visited[nr][nc] = true;
                }
            }

            move++;
        }
    }

}
