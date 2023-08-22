import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node o) {
            if (this.right == o.right) {
                return Integer.compare(this.left, o.left);
            }
            return Integer.compare(this.right, o.right);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pq.add(new Node(Math.min(a, b), Math.max(a, b)));
        }

        int d = Integer.parseInt(br.readLine());

        int max = 0;
        PriorityQueue<Integer> count = new PriorityQueue<>();
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            count.add(curr.left);

            while (!count.isEmpty() && curr.right - d > count.peek()) {
                count.poll();
            }

            max = Math.max(max, count.size());
        }

        System.out.println(max);
    }

}