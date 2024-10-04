import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            union(x, y);
        }

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        int hansol = findSet(c);
        int sejin = findSet(h);

        for (int i = 1; i < n + 1; i++) {
            int num = findSet(parent[i]);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int answer = map.get(hansol);
        answer += map.entrySet().stream()
                .filter(e -> e.getKey() != hansol && e.getKey() != sejin)
                .sorted((a, b) -> b.getValue() - a.getValue())
                .limit(k)
                .mapToInt(e -> e.getValue()).sum();

        System.out.println(answer);
    }

    private static void union(int x, int y) {
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
        } else {
            parent[x] = findSet(parent[x]);
            return parent[x];
        }
    }

}
