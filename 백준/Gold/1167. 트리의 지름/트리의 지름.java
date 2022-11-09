import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int to, cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static int V, ans, end;
    static int[] in_degree;
    static List<Node>[] graph;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        V = Integer.parseInt(br.readLine());

        in_degree = new int[V];
        graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            while (true) {
                int to = Integer.parseInt(st.nextToken()) - 1;
                if (to == -2) {
                    break;
                }

                int cost = Integer.parseInt(st.nextToken());
                in_degree[to]++;
                graph[from].add(new Node(to, cost));
            }
        }

        ans = 0;
        end = 0;
        visit = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (in_degree[i] == 1) {
                visit[i] = true;
                dfs(i, 0);
                visit[i] = false;
                break;
            }
        }

        visit[end] = true;
        dfs(end, 0);
        System.out.println(ans);

    }

    public static void dfs(int from, int sum) {

        boolean isFinished = true;
        for (Node next : graph[from]) {
            if (visit[next.to]) {
                continue;
            } else {
                isFinished = false;
            }
            visit[next.to] = true;
            dfs(next.to, sum + next.cost);
            visit[next.to] = false;
        }

        if (isFinished) {
            if(sum > ans) {
                ans = sum;
                end = from;
            }
            return;
        }
    }

}