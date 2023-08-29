import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visit;
    static int[] owner;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            for (int i = 1; i <= m + 1; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 1; i < m + 1; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                for (int j = a; j <= b; j++) {
                    list.get(i).add(j);
                }
            }

            owner = new int[n + 1];
            visit = new boolean[n + 1];

            int cnt = 0;
            for (int i = 1; i <= m; i++) {
                Arrays.fill(visit, false);
                if (dfs(i)) {
                    cnt++;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    private static boolean dfs(int idx) {
        for (int num : list.get(idx)) {
            if (visit[num]) {
                continue;
            }
            visit[num] = true;

            if (owner[num] == 0 || dfs(owner[num])) {
                owner[num] = idx;
                return true;
            }
        }

        return false;
    }

}