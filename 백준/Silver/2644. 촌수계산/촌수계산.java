import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.get(x).add(y);
            list.get(y).add(x);
        }

        int answer = bfs(a, b);

        System.out.println(answer);
    }

    private static int bfs(int a, int b) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);

        boolean[] visited = new boolean[n + 1];
        visited[a] = true;

        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();

                if (node == b) {
                    return depth;
                }

                for (int next : list.get(node)) {
                    if (visited[next]) {
                        continue;
                    }

                    visited[next] = true;
                    queue.add(next);
                }
            }

            depth++;
        }

        return -1;
    }

}