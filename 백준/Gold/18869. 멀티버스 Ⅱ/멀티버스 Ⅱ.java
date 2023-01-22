import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int val, idx;

        public Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node n) {
            return this.val - n.val;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < M; i++) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int v = Integer.parseInt(st.nextToken());
                pq.add(new Node(v, j));
            }

            int[] tmp = new int[N];
            int num = 0;
            int prev = 0;
            while (!pq.isEmpty()) {
                Node node = pq.poll();
                if (node.val == prev) {
                    tmp[node.idx] = num;
                } else {
                    num++;
                    tmp[node.idx] = num;
                }
                prev = node.val;
            }

            String s = Arrays.toString(tmp);
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int ans = 0;
        for (String key : map.keySet()) {
            int n = map.get(key);
            ans += n * (n - 1) / 2;
        }

        System.out.println(ans);

    }
}