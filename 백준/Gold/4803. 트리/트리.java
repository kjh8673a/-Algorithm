import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int idx = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0) {
                break;
            }

            parent = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }

            int count = 0;
            for (int i = 1; i < n + 1; i++) {
                int pa = find(i);
                if (pa == i) {
                    count++;
                }
            }

            sb.append("Case " + idx + ": ");
            if (count == 0) {
                sb.append("No trees.");
            } else if (count == 1) {
                sb.append("There is one tree.");
            } else {
                sb.append("A forest of " + count + " trees.");
            }
            sb.append("\n");

            idx++;
        }

        System.out.println(sb);
    }

    private static void union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px < py) {
            parent[py] = px;
        } else if (px == py) {
            parent[px] = 0;
        } else {
            parent[px] = py;
        }
    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }

}