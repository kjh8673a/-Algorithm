
import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node> {
        int idx;
        int color;
        int size;

        public Node(int idx, int color, int size) {
            this.idx = idx;
            this.color = color;
            this.size = size;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.size, o.size);
        }
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Node(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int[] ans = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        int prevEat = 0;
        int eat = 0;
        int prevSize = 0;
        Queue<Node> queue = new LinkedList<>();
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (prevSize != node.size) {
                eat += prevEat;
                prevEat = 0;
                while (!queue.isEmpty()) {
                    Node prevNode = queue.poll();
                    map.put(prevNode.color, map.getOrDefault(prevNode.color, 0) + prevNode.size);
                }
            }
            prevSize = node.size;
            prevEat += node.size;
            queue.add(new Node(node.idx, node.color, node.size));

            ans[node.idx] = eat - map.getOrDefault(node.color, 0);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(ans[i]).append("\n");
        }

        System.out.println(sb);

    }

}
