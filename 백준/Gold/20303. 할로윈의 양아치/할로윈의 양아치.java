import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int cost;
        long value;

        public Node(int cost, long value) {
            this.cost = cost;
            this.value = value;
        }
    }

    static int N, M, K;
    static int[] candy, person, group;
    static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        candy = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
        }

        person = new int[N + 1];
        Arrays.fill(person, 1);

        group = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            group[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            makeGroup(a, b);
        }

        makeList();

        System.out.println(doDp());
    }

    private static long doDp() {
        long[][] dp = new long[list.size() + 1][K];

        for (int i = 1; i < list.size() + 1; i++) {
            int cost = list.get(i - 1).cost;
            long value = list.get(i - 1).value;

            for (int j = 0; j < K; j++) {
                if (cost <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost] + value);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[list.size()][K - 1];
    }

    private static void makeList() {
        for (int i = 1; i < N + 1; i++) {
            if (group[i] != i) {
                int p = findGroup(i);
                candy[p] += candy[i];
                person[p] += person[i];
            }
        }

        for (int i = 1; i < N + 1; i++) {
            if (group[i] == i) {
                list.add(new Node(person[i], candy[i]));
            }
        }
    }

    private static void makeGroup(int a, int b) {
        int pa = findGroup(a);
        int pb = findGroup(b);

        if (pa < pb) {
            group[pb] = pa;
        } else {
            group[pa] = pb;
        }
    }

    private static int findGroup(int a) {
        if (a == group[a]) {
            return a;
        }
        return group[a] = findGroup(group[a]);
    }

}
