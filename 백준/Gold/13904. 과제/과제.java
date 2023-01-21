import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int due;
        int score;

        public Node(int due, int score) {
            this.due = due;
            this.score = score;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(o.score, this.score);
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int len = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if (d > len) {
                len = d;
            }
            pq.add(new Node(d, w));
        }

        int[] arr = new int[len + 1];
        int sum = 0;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            for (int i = node.due; i > 0; i--) {
                if (node.score > arr[i]) {
                    sum -= arr[i];
                    sum += node.score;
                    arr[i] = node.score;
                    break;
                }
            }
        }

        System.out.println(sum);

    }
}