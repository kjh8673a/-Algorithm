import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        int[] in_degree = new int[N + 1];
        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            in_degree[v]++;
            list[v].add(u);
            in_degree[u]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if (in_degree[i] == 1) {
                queue.add(i);
            }
        }
        boolean[] check = new boolean[N + 1];
        int ans = 0;
        while (!queue.isEmpty()) {
            int num = queue.poll();
            for (int next : list[num]) {
                if (!check[next] && !check[num]) {
                    check[next] = true;
                    ans++;
                }
                in_degree[next]--;
                if (in_degree[next] == 1) {
                    queue.add(next);
                }
            }
        }

        System.out.println(ans);

    }
}
