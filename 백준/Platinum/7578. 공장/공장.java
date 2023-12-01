import java.util.*;
import java.io.*;

public class Main {
    static class SegmentTree {
        long[] tree;

        public SegmentTree(int arrSize) {
            int height = (int) Math.ceil(Math.log(arrSize) / Math.log(2)) + 1;
            tree = new long[(1 << height)];
        }

        public void update(int node, int start, int end, int idx, int diff) {
            if (idx < start || idx > end) {
                return;
            }

            tree[node] += diff;

            if (start != end) {
                update(node * 2, start, (start + end) / 2, idx, diff);
                update(node * 2 + 1, (start + end) / 2 + 1, end, idx, diff);
            }
        }

        public long sum(int node, int start, int end, int left, int right) {
            if (left > end || right < start) {
                return 0;
            }

            if (left <= start && right >= end) {
                return tree[node];
            }

            return sum(node * 2, start, (start + end) / 2, left, right)
                    + sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[1_000_001];
        for (int i = 1; i < N + 1; i++) {
            arr[Integer.parseInt(st.nextToken())] = i;
        }

        int[] index = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            index[i] = arr[Integer.parseInt(st.nextToken())];
        }

        SegmentTree seg = new SegmentTree(N);

        long ans = 0;
        for (int i = 1; i < N + 1; i++) {
            ans += seg.sum(1, 1, N, index[i] + 1, N);
            seg.update(1, 1, N, index[i], 1);
        }

        System.out.println(ans);
    }
}