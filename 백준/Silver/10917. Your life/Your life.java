import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.get(x).add(y);
        }

        int answer = bfs(list, n);

        System.out.println(answer);
    }

    private static int bfs(ArrayList<ArrayList<Integer>> list, int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        int depth = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int node = queue.poll();

                if (node == n) {
                    return depth;
                }

                for (int next : list.get(node)) {
                    if (visited[next]) {
                        continue;
                    }

                    queue.add(next);
                    visited[next] = true;
                }
            }

            depth++;
        }

        return -1;
    }

}
