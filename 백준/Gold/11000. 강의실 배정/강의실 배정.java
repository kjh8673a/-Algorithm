import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int s;
        int e;

        public Node(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node[] table = new Node[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            table[i] = new Node(s, e);
        }
        Arrays.sort(table, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.s == o2.s) {
                    return Integer.compare(o1.e, o2.e);
                } else {
                    return Integer.compare(o1.s, o2.s);
                }
            }
        });

        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            if (!pq.isEmpty() && pq.peek() <= table[i].s) {
                pq.poll();
            } else {
                ans++;
            }
            pq.offer(table[i].e);
        }

        System.out.println(ans);
    }

}