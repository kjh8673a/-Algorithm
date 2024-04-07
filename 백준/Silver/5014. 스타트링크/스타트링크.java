import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        boolean[] visited = new boolean[f + 1];
        visited[s] = true;

        int answer = -1;
        int depth = 0;

        loop: while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int node = queue.poll();

                if (node == g) {
                    answer = depth;
                    break loop;
                }

                if (node + u <= f && !visited[node + u]) {
                    visited[node + u] = true;
                    queue.add(node + u);
                }

                if (node - d > 0 && !visited[node - d]) {
                    visited[node - d] = true;
                    queue.add(node - d);
                }
            }

            depth++;
        }

        if (answer == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(answer);
        }
    }

}