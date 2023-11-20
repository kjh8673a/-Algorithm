import java.util.*;
import java.io.*;

public class Main {
    static class SegmentTree {
        long[] tree;

        public SegmentTree(int arrSize) {
            tree = new long[arrSize * 4];
        }

        public void update(int node, int start, int end, int idx) {
            if (idx < start || end < idx) {
                return;
            }

            tree[node] += 1;

            if (start != end) {
                update(node * 2, start, (start + end) / 2, idx);
                update(node * 2 + 1, (start + end) / 2 + 1, end, idx);
            }
        }

        public long sum(int node, int start, int end, int left, int right) {
            if (left > end || right < start) {
                return 0;
            }

            if (left <= start && end <= right) {
                return tree[node];
            }

            return sum(node * 2, start, (start + end) / 2, left, right)
                    + sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        }
    }

    static class Node {
        int idx;
        int skill;

        public Node(int idx, int skill) {
            this.idx = idx;
            this.skill = skill;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            list.add(new Node(i, x));
        }
        Collections.sort(list, (a, b) -> (a.skill - b.skill));
        for (int i = 0; i < N; i++) {
            list.get(i).skill = i + 1;
        }
        Collections.sort(list, (a, b) -> (a.idx - b.idx));

        SegmentTree seg = new SegmentTree(N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int x = list.get(i).skill;
            seg.update(1, 1, N, x);

            long result = i - seg.sum(1, 1, N, 1, x) + 2;
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

}