import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs());
    }

    static class Node {
        int point;
        int visited;

        public Node(int point, int visited) {
            this.point = point;
            this.visited = visited;
        }
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 1 << 0));

        boolean[][] visit = new boolean[n][1 << n];
        visit[0][1 << 0] = true;

        int result = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (Integer.bitCount(node.visited) == k) {
                int tmp = 0;
                for (int i = 0; i < n; i++) {
                    if ((node.visited & (1 << i)) > 0) {
                        tmp += arr[i];
                    }
                }
                result = Math.max(result, tmp);
                continue;
            }

            for (int next : graph.get(node.point)) {
                if ((node.visited & (1 << next)) == 0) {
                    visit[next][node.visited | (1 << next)] = true;
                    queue.add(new Node(next, node.visited | (1 << next)));
                } else {
                    if (!visit[next][node.visited | (1 << next)]) {
                        visit[next][node.visited | (1 << next)] = true;
                        queue.add(new Node(next, node.visited | (1 << next)));
                    }
                }
            }
        }

        return result;
    }

}