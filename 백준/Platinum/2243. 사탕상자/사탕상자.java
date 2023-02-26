import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static class SegmentTree {
        long[] tree = new long[1000000 * 4];

        // public long init(int node, int start, int end) {
        //     if (start == end) {
        //         return tree[node] = 0;
        //     } else {
        //         return init(node * 2, start, (start + end) / 2) + init(node * 2 + 1, (start + end) / 2 + 1, end);
        //     }
        // }

        public void update(int node, int start, int end, int idx, long diff) {
            if (idx < start || idx > end) {
                return;
            }

            tree[node] += diff;

            if (start != end) {
                update(node * 2, start, (start + end) / 2, idx, diff);
                update(node * 2 + 1, (start + end) / 2 + 1, end, idx, diff);
            }
        }

        public long print(int node, int start, int end, long num) {
            if (start == end) {
                sb.append(start + "\n");
                return tree[node] -= 1;
            }

            if (num <= tree[node * 2]) {
                return tree[node] = print(node * 2, start, (start + end) / 2, num) + tree[node * 2 + 1];
            } else {
                return tree[node] = tree[node * 2]
                        + print(node * 2 + 1, (start + end) / 2 + 1, end, num - tree[node * 2]);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        SegmentTree seg = new SegmentTree();
        // seg.init(1, 1, 1000000);

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == 2) {
                int b = Integer.parseInt(st.nextToken());
                long c = Long.parseLong(st.nextToken());
                seg.update(1, 1, 1000000, b, c);
            } else {
                long b = Long.parseLong(st.nextToken());
                seg.print(1, 1, 1000000, b);
            }
        }

        System.out.println(sb);

    }

}