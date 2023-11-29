import java.util.*;
import java.io.*;

public class Main {
    static class SegmentTree {
        int[] tree;

        public SegmentTree(int arrSize) {
            int height = (int) Math.ceil(Math.log(arrSize) / Math.log(2)) + 1;
            tree = new int[(1 << height)];
        }

        public int init(int[] arr, int node, int start, int end) {
            if (start == end) {
                return tree[node] = arr[start];
            }

            return tree[node] = init(arr, node * 2, start, (start + end) / 2)
                    * init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
        }

        public int update(int node, int start, int end, int idx, int diff) {
            if (idx < start || idx > end) {
                return tree[node];
            }

            if (start == end) {
                return tree[node] = diff;
            }

            return tree[node] = update(node * 2, start, (start + end) / 2, idx, diff)
                    * update(node * 2 + 1, (start + end) / 2 + 1, end, idx, diff);
        }

        public int getValue(int node, int start, int end, int left, int right) {
            if (right < start || left > end) {
                return 1;
            }

            if (left <= start && end <= right) {
                return tree[node];
            }

            return getValue(node * 2, start, (start + end) / 2, left, right)
                    * getValue(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String input = "";
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] arr = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < N + 1; i++) {
                int x = Integer.parseInt(st.nextToken());
                arr[i] = (x == 0) ? 0 : (x > 0) ? 1 : -1;
            }

            SegmentTree seg = new SegmentTree(N);
            seg.init(arr, 1, 1, N);

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                String type = st.nextToken();
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if (type.equals("C")) {
                    b = (b == 0) ? 0 : (b > 0) ? 1 : -1;
                    seg.update(1, 1, N, a, b);
                    arr[a] = b;
                } else {
                    int val = seg.getValue(1, 1, N, a, b);
                    sb.append((val == 0) ? 0 : (val > 0) ? "+" : "-");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}