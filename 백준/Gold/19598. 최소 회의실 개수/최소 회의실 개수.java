import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node> {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            if (this.start == o.start) {
                return Integer.compare(this.end, o.end);
            }
            return Integer.compare(this.start, o.start);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        PriorityQueue<Integer> room = new PriorityQueue<>();
        room.add(pq.poll().end);
        int cnt = 1;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (room.peek() <= node.start) {
                room.poll();
            } else {
                cnt++;
            }
            room.add(node.end);
        }

        System.out.println(cnt);
    }

}
