import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int m;
        int v;

        public Node(int m, int v) {
            this.m = m;
            this.v = v;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Node[] gem = new Node[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            gem[i] = new Node(m, v);
        }

        Arrays.sort(gem, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.m == o2.m) {
                    return Integer.compare(o2.v, o1.v);
                } else {
                    return Integer.compare(o1.m, o2.m);
                }
            }

        });

        int[] bag = new int[M];
        for (int i = 0; i < M; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);

        long ans = 0;
        int idx = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < M; i++) {
            int size = bag[i];
            while (idx < N && gem[idx].m <= size) {
                pq.add(gem[idx++].v);
            }

            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
        }

        System.out.println(ans);
    }

}