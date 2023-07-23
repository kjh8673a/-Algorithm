import java.io.*;
import java.util.*;

public class Main {
    static int N, ans;
    static int[] arr, color;
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visit, isColored;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        color = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            color[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList<>();
        for (int i = 1; i <= N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        ans = 0;
        visit = new boolean[N + 1];
        dfs(1, 0);

        System.out.println(ans);
    }

    private static void dfs(int node, int prev) {
        visit[node] = true;
        arr[node] = arr[prev];

        if (arr[node] != color[node]) {
            arr[node] = color[node];
            ans++;
        }

        for (int next : list.get(node)) {
            if (!visit[next]) {
                dfs(next, node);
            }
        }
    }

}
