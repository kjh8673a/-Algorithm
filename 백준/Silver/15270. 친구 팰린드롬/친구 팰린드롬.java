import java.io.*;
import java.util.*;

public class Main {
    static int n, m, answer;
    static ArrayList<ArrayList<Integer>> connection;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        connection = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            connection.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            connection.get(u).add(v);
            connection.get(v).add(u);
        }

        answer = 0;
        visited = new boolean[n + 1];
        dfs(1, 0);

        System.out.println(answer < n ? answer + 1 : answer);
    }

    private static void dfs(int idx, int cnt) {
        if (idx == n + 1) {
            answer = Math.max(cnt * 2, answer);
            return;
        }

        if (visited[idx]) {
            dfs(idx + 1, cnt);
            return;
        }
        visited[idx] = true;

        for (int next : connection.get(idx)) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(idx + 1, cnt + 1);
                visited[next] = false;
            }
        }

        visited[idx] = false;
        dfs(idx + 1, cnt);
    }

}