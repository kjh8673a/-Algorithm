import java.io.*;
import java.util.*;

public class Main {
    static int V, E, discoveredIndex;
    static int[] discoveredOrder;
    static ArrayList<ArrayList<Integer>> singleNodegraph;
    static ArrayList<TreeSet<Integer>> SCC;
    static boolean[] alreadyInSCC;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        singleNodegraph = new ArrayList<>();
        SCC = new ArrayList<>();
        for (int i = 0; i < V + 1; i++) {
            singleNodegraph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            singleNodegraph.get(b).add(a);
        }

        discoveredOrder = new int[V + 1];
        discoveredIndex = 0;
        alreadyInSCC = new boolean[V + 1];
        for (int i = 1; i < V + 1; i++) {
            if (discoveredOrder[i] == 0) {
                makeSCC(i);
            }
        }

        Collections.sort(SCC, (o1, o2) -> o1.first() - o2.first());

        StringBuilder sb = new StringBuilder();
        sb.append(SCC.size()).append("\n");
        for (TreeSet<Integer> set : SCC) {
            set.stream().forEach(node -> sb.append(node).append(" "));
            sb.append("-1").append("\n");
        }

        System.out.println(sb);
    }

    private static int makeSCC(int x) {
        discoveredOrder[x] = ++discoveredIndex;
        stack.push(x);

        int root = discoveredOrder[x];
        for (int next : singleNodegraph.get(x)) {
            if (discoveredOrder[next] == 0) {
                root = Math.min(root, makeSCC(next));
            } else if (!alreadyInSCC[next]) {
                root = Math.min(root, discoveredOrder[next]);
            }
        }

        if (root == discoveredOrder[x]) {
            TreeSet<Integer> SCC_group = new TreeSet<>();
            while (!stack.isEmpty()) {
                int node = stack.pop();
                SCC_group.add(node);
                alreadyInSCC[node] = true;
                if (node == x) {
                    break;
                }
            }
            SCC.add(SCC_group);
        }

        return root;
    }

}