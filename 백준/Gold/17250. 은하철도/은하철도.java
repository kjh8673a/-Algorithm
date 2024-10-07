import java.io.*;
import java.util.*;

public class Main {
    static int[] parent, planet;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        planet = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
            planet[i] = Integer.parseInt(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(planet[union(a, b)]).append("\n");
        }

        System.out.println(sb);
    }

    private static int findSet(int x) {
        if (x == parent[x]) {
            return x;
        } else {
            parent[x] = findSet(parent[x]);
            return parent[x];
        }
    }

    private static int union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);
        if (px == py) {
            return px;
        }

        if (planet[px] > planet[py]) {
            parent[py] = px;
            planet[px] += planet[py];
            return px;
        } else {
            parent[px] = py;
            planet[py] += planet[px];
            return py;
        }
    }

}
