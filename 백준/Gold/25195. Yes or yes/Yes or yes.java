import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] fanClub;
    static boolean success;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
        }

        int s = Integer.parseInt(br.readLine());

        fanClub = new boolean[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) {
            int a = Integer.parseInt(st.nextToken());
            fanClub[a] = true;
        }

        success = false;
        dfs(1, fanClub[1]);

        System.out.println(success ? "yes" : "Yes");
    }

    private static void dfs(int node, boolean fan) {
        boolean flag = false;
        for (int next : graph.get(node)) {
            if (next != node) {
                flag = true;
                if (fanClub[next]) {
                    dfs(next, true);
                } else {
                    dfs(next, fan);
                }
            }
        }

        if (!flag) {
            if (!fan) {
                success = true;
            }
            return;
        }
    }

}