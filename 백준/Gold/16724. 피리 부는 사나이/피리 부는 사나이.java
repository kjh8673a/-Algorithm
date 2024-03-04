import java.io.*;
import java.util.*;

public class Main {
    static int[][] vector = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    static int n, m;
    static int[] parent;
    static int[][] table;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n * m];
        table = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                parent[i * m + j] = i * m + j;
                switch (line[j]) {
                    case 'U':
                        table[i][j] = 0;
                        break;
                    case 'D':
                        table[i][j] = 1;
                        break;
                    case 'L':
                        table[i][j] = 2;
                        break;
                    case 'R':
                        table[i][j] = 3;
                        break;
                }
            }
        }

        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n * m; i++) {
            set.add(findSet(i));
        }

        System.out.println(set.size());
    }

    private static void dfs(int r, int c) {
        if (visited[r][c]) {
            return;
        }

        visited[r][c] = true;
        int type = table[r][c];
        int nr = r + vector[type][0];
        int nc = c + vector[type][1];

        if (isInbound(nr, nc)) {
            union(r, c, nr, nc);
            dfs(nr, nc);
        }
    }

    private static boolean isInbound(int r, int c) {
        if (r < 0 || c < 0 || r >= n || c >= m) {
            return false;
        }
        return true;
    }

    private static void union(int r, int c, int nr, int nc) {
        int x = r * m + c;
        int y = nr * m + nc;

        int px = findSet(x);
        int py = findSet(y);

        if (px < py) {
            parent[py] = px;
        } else {
            parent[px] = py;
        }
    }

    private static int findSet(int x) {
        if (x == parent[x]) {
            return x;
        }
        parent[x] = findSet(parent[x]);
        return parent[x];
    }

}