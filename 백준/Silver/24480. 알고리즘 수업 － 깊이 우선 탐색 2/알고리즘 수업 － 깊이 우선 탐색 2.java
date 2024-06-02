import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> list;
    static int[] answer;
    static int order;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }

        answer = new int[n + 1];
        order = 1;
        dfs(r);

        StringBuilder sb = new StringBuilder();
        Arrays.stream(answer).skip(1).forEach(v -> sb.append(v).append("\n"));

        System.out.println(sb);
    }

    private static void dfs(int node) {
        answer[node] = order++;

        Collections.sort(list.get(node), Collections.reverseOrder());
        for (int next : list.get(node)) {
            if (answer[next] > 0) {
                continue;
            }
            dfs(next);
        }
    }
}