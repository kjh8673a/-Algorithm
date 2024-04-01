import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        int round = 0;
        while (!queue.isEmpty() && round < 2) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int node = queue.poll();

                for (int next : list.get(node)) {
                    if (visited[next]) {
                        continue;
                    }

                    answer++;
                    visited[next] = true;
                    queue.add(next);
                }
            }

            round++;
        }

        System.out.println(answer);
    }

}