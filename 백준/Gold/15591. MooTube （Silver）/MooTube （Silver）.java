import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static int n;
    static ArrayList<ArrayList<Node>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b, c));
            list.get(b).add(new Node(a, c));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(connect(a, b)).append("\n");
        }

        System.out.println(sb);
    }

    private static int connect(int k, int v) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];
        queue.add(v);
        visit[v] = true;

        int answer = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (Node next : list.get(node)) {
                if (visit[next.v]) {
                    continue;
                }

                if (next.cost >= k) {
                    answer++;
                    queue.add(next.v);
                    visit[next.v] = true;
                }
            }
        }

        return answer;
    }

}