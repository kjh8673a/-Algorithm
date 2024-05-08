import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> list;
    static int[] score;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            int boss = Integer.parseInt(st.nextToken());
            if (boss != -1) {
                list.get(boss).add(i);
            }
        }

        score = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            score[idx] += w;
        }

        visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                bfs(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            sb.append(score[i] + " ");
        }

        System.out.println(sb);
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int next : list.get(node)) {
                visited[next] = true;
                score[next] += score[node];
                queue.add(next);
            }
        }
    }

}