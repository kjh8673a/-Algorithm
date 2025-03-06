import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        visited[x] = true;
        queue.add(x);

        ArrayList<Integer> answer = new ArrayList<>();

        int depth = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                int node = queue.poll();

                if (depth == k) {
                    answer.add(node);
                    continue;
                }

                for (int next : graph.get(node)) {
                    if (visited[next]) {
                        continue;
                    }
                    visited[next] = true;
                    queue.add(next);
                }
            }

            depth++;
        }

        if (answer.size() == 0) {
            System.out.println(-1);
        } else {
            Collections.sort(answer);
            StringBuilder sb = new StringBuilder();
            for (int node : answer) {
                sb.append(node).append("\n");
            }

            System.out.println(sb.toString());
        }
    }
}