import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int time;
        int type;

        public Node(int time, int type) {
            this.time = time;
            this.type = type;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        StringTokenizer st;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.add(new Node(Integer.parseInt(st.nextToken()), 1));
            pq.add(new Node(Integer.parseInt(st.nextToken()) + 1, -1));
        }

        int[] table = new int[1000002];
        
        int cnt = 0;
        int prev = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int time = node.time;
            for(int i = prev; i < time; i++) {
                table[i] = cnt;
            }
            cnt += node.type;
            prev = time;
        }
        table[prev] = cnt;

        StringBuilder sb = new StringBuilder();
        int Q = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < Q; i++) {
            int a = Integer.parseInt(st.nextToken());
            sb.append(table[a]).append("\n");
        }

        System.out.println(sb);

    }
}
