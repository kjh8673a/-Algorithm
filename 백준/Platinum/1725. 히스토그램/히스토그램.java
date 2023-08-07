import java.io.*;
import java.util.*;

public class Main {

    static class SegmentTree {
        int[] tree;

        public SegmentTree(int arrSize) {
            tree = new int[arrSize * 4];
        }

        public int init(int node, int start, int end) {
            if (start == end) {
                return tree[node] = start;
            } else {
                int a = init(node * 2, start, (start + end) / 2);
                int b = init(node * 2 + 1, (start + end) / 2 + 1, end);
                return tree[node] = arr[a] < arr[b] ? a : b;
            }
        }

        public int find(int node, int start, int end, int left, int right) {
            if (left > end || right < start) {
                return 0;
            }

            if (left <= start && end <= right) {
                return tree[node];
            }

            int a = find(node * 2, start, (start + end) / 2, left, right);
            int b = find(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
            return arr[a] < arr[b] ? a : b;
        }
    }

    static int N;
    static long[] arr;
    static SegmentTree seg;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new long[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        arr[0] = Long.MAX_VALUE;

        seg = new SegmentTree(N);
        seg.init(1, 1, N);

        ans = 0;
        solve(1, N);

        System.out.println(ans);
    }

    private static void solve(int left, int right) {
        if (left > right) {
            return;
        }

        int idx = seg.find(1, 1, N, left, right);
        ans = Math.max(ans, arr[idx] * (right - left + 1));

        solve(left, idx - 1);
        solve(idx + 1, right);
    }

}