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
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        int answer = 0;
        int[] lecture = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            lecture[i] = Integer.parseInt(st.nextToken());
            if (i > 0 && find(lecture[i]) != find(lecture[i - 1])) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa > pb) {
            parent[pb] = pa;
        } else {
            parent[pa] = pb;
        }
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        } else {
            parent[a] = find(parent[a]);
            return parent[a];
        }
    }

}