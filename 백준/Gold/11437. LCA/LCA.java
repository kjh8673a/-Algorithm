import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static ArrayList<ArrayList<Integer>> list;
    static int[] parent, depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 정점의 개수
        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            // 서로 연결된 두 정점
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        parent = new int[N + 1];
        depth = new int[N + 1];

        // 루트 노드 1번부터 depth를 1로 하여 dfs탐색으로 트리 만들기
        dfs(1, 1);

        // 공통 조상을 알고 싶은 쌍의 개수
        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int ans = lca(u, depth[u], v, depth[v]);
            sb.append(ans).append("\n");
        }

        System.out.println(sb);

    }

    static void dfs(int from, int cnt) {
        depth[from] = cnt;

        for (int next : list.get(from)) {
            if (depth[next] != 0) {
                continue;
            }
            dfs(next, cnt + 1);
            parent[next] = from;
        }
    }

    static int lca(int a, int depth_A, int b, int depth_B) {
        if (depth_A > depth_B) {
            while (depth_A > depth_B) {
                depth_A--;
                a = parent[a];
            }
        } else if (depth_A < depth_B) {
            while (depth_A < depth_B) {
                depth_B--;
                b = parent[b];
            }
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }
}
