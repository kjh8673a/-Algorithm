import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] children = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            children[i] = new ArrayList<>();
        }
        int[] parent = new int[n + 1];

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            children[x].add(y);
            parent[y] = x;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        boolean[] visited = new boolean[n + 1];
        visited[a] = true;

        boolean flag = false;
        int depth = 0;
        loop: while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int node = queue.poll();

                if (node == b) {
                    flag = true;
                    break loop;
                }

                int p = parent[node];
                if (!visited[p]) {
                    queue.add(p);
                    visited[p] = true;
                }

                for (int c : children[node]) {
                    if (!visited[c]) {
                        queue.add(c);
                        visited[c] = true;
                    }
                }
            }
            depth++;
        }

        System.out.println(flag ? depth : -1);
    }

}