import java.io.*;
import java.util.*;

public class Main {
    static int[] group, price;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        group = new int[n + 1];
        price = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            group[i] = i;
            price[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            union(v, w);
        }

        int sum = 0;
        boolean[] selected = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            int num = find(group[i]);
            if (selected[num]) {
                continue;
            }
            selected[num] = true;
            sum += price[num];
        }

        if (k < sum) {
            System.out.println("Oh no");
        } else {
            System.out.println(sum);
        }
    }

    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (price[pa] < price[pb]) {
            group[pb] = pa;
        } else {
            group[pa] = pb;
        }
    }

    private static int find(int a) {
        if (a == group[a]) {
            return a;
        } else {
            return group[a] = find(group[a]);
        }
    }

}