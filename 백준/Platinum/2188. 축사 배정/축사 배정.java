import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visit;
    static int[] cow;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 1; i <= n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            for (int j = 0; j < s; j++) {
                int a = Integer.parseInt(st.nextToken());
                list.get(i).add(a);
            }
        }

        visit = new boolean[m + 1];
        cow = new int[m + 1];

        int cnt = 0;
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(visit, false);
            if (dfs(i)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static boolean dfs(int idx) {
        for (int cage : list.get(idx)) {
            if (visit[cage]) {
                continue;
            }
            visit[cage] = true;

            if (cow[cage] == 0 || dfs(cow[cage])) {
                cow[cage] = idx;
                return true;
            }
        }

        return false;
    }

}