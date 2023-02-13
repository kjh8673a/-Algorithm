import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1000000007;

    static class SegmentTree {
        long[] tree;

        public SegmentTree(int arrSize) {
            tree = new long[arrSize * 4];
        }

        public long init(long[] arr, int node, int start, int end) {
            if (start == end) {
                return tree[node] = arr[start];
            } else {
                return tree[node] = (init(arr, node * 2, start, (start + end) / 2)
                        * init(arr, node * 2 + 1, (start + end) / 2 + 1, end)) % MOD;
            }
        }

        public long update(int node, int start, int end, int idx, long after) {
            if (idx < start || idx > end) {
                return tree[node];
            }
            if (start == end && start == idx) {
                return tree[node] = after;
            } else {
                return tree[node] = (update(node * 2, start, (start + end) / 2, idx, after) *
                        update(node * 2 + 1, (start + end) / 2 + 1, end, idx, after)) % MOD;
            }
        }

        public long multiply(int node, int start, int end, int left, int right) {
            if (left > end || right < start) {
                return 1;
            }
            if (left <= start && end <= right) {
                return tree[node];
            }
            return multiply(node * 2, start, (start + end) / 2, left, right)
                    * multiply(node * 2 + 1, (start + end) / 2 + 1, end, left, right) % MOD;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        SegmentTree seg = new SegmentTree(N);
        seg.init(arr, 1, 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                seg.update(1, 1, N, b, c);
                arr[b] = c;
            } else {
                sb.append(seg.multiply(1, 1, N, b, (int) c) + "\n");
            }
        }

        System.out.println(sb);

    }

}