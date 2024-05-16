import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static int start, end, answer;
    static ArrayList<ArrayList<Node>> list;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }

        answer = Integer.MAX_VALUE;
        visited = new int[n + 1];
        dfs(start);

        System.out.println(answer);
    }

    private static void dfs(int idx) {
        if (idx == end) {
            int max = 0;
            int sum = 0;
            for (int i = 0; i < visited.length; i++) {
                sum += visited[i];
                max = Math.max(max, visited[i]);
            }
            answer = Math.min(answer, sum - max);

            return;
        }

        for (Node next : list.get(idx)) {
            if (visited[next.v] > 0) {
                continue;
            }

            visited[next.v] = next.cost;
            dfs(next.v);
            visited[next.v] = 0;
        }
    }

}