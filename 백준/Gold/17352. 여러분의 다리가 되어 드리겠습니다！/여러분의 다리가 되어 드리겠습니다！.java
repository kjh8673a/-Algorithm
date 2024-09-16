import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        StringTokenizer st;
        for (int i = 0; i < n - 2; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(findSet(1) + " ");
        for (int i = 2; i < n + 1; i++) {
            if (findSet(i) != findSet(1)) {
                sb.append(findSet(i));
                break;
            }
        }

        System.out.println(sb);
    }

    private static void union(int a, int b) {
        int pa = findSet(a);
        int pb = findSet(b);
        if (pa > pb) {
            parent[pa] = pb;
        } else {
            parent[pb] = pa;
        }
    }

    private static int findSet(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = findSet(parent[a]);
    }

}