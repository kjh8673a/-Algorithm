import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static int ans, end, n;
    static List<Node>[] list;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, cost));
            list[b].add(new Node(a, cost));
        }

        ans = 0;
        end = 0;
        visit = new boolean[n + 1];
        visit[1] = true;
        dfs(1, 0);
        visit[1] = false;

        visit[end] = true;
        dfs(end, 0);
        System.out.println(ans);
    }

    public static void dfs(int v, int sum) {
        boolean isFinished = true;
        for (Node next : list[v]) {
            if (visit[next.v]) {
                continue;
            } else {
                isFinished = false;
            }
            visit[next.v] = true;
            dfs(next.v, sum + next.cost);
            visit[next.v] = false;
        }

        if (isFinished) {
            if (sum > ans) {
                ans = sum;
                end = v;
            }
            return;
        }
    }

}