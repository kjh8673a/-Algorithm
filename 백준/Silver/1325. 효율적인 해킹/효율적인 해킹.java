import java.io.*;
import java.util.*;

public class Main {
    static int N, M, id, groupId;
    static int[] d, group;
    static ArrayList<ArrayList<Integer>> graph;
    static ArrayList<TreeSet<Integer>> SCC;
    static ArrayList<Set<Integer>> groupGraph;
    static boolean[] finished, visitedGroup;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        SCC = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(b).add(a);
        }

        d = new int[N + 1];
        id = 0;
        groupId = 0;
        group = new int[N + 1];
        finished = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            if (d[i] == 0) {
                dfs(i);
            }
        }

        groupGraph = new ArrayList<>();
        for (int i = 0; i < groupId; i++) {
            groupGraph.add(new HashSet<>());
        }

        int[] groupInDegree = new int[groupId];
        for (int i = 1; i < N + 1; i++) {
            for (int next : graph.get(i)) {
                if (group[i] != group[next] && !groupGraph.get(group[i]).contains(group[next])) {
                    groupInDegree[group[next]]++;
                    groupGraph.get(group[i]).add(group[next]);
                }
            }
        }

        int[] groupResult = new int[groupId];
        int max = 0;
        for (int i = 0; i < groupId; i++) {
            if (groupInDegree[i] == 0) {
                visitedGroup = new boolean[groupId];
                groupResult[i] = groupCount(i);
                max = Math.max(max, groupResult[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < groupId; i++) {
            if (groupResult[i] == max) {
                for (Integer node : SCC.get(i)) {
                    sb.append(node + " ");
                }
            }
        }

        System.out.println(sb);
    }

    private static int groupCount(int x) {
        visitedGroup[x] = true;
        int count = SCC.get(x).size();
        for (int next : groupGraph.get(x)) {
            if (!visitedGroup[next]) {
                count += groupCount(next);
            }
        }

        return count;
    }

    private static int dfs(int x) {
        d[x] = ++id;
        stack.push(x);

        int root = d[x];
        for (int next : graph.get(x)) {
            if (d[next] == 0) {
                root = Math.min(root, dfs(next));
            } else if (!finished[next]) {
                root = Math.min(root, d[next]);
            }
        }

        if (root == d[x]) {
            SCC.add(new TreeSet<>());
            while (!stack.isEmpty()) {
                int node = stack.pop();
                SCC.get(groupId).add(node);
                group[node] = groupId;
                finished[node] = true;
                if (node == x) {
                    break;
                }
            }
            groupId++;
        }

        return root;
    }

}