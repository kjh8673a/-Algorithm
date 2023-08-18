import java.io.*;
import java.util.*;

public class Main {
    static class segmentTree {
        int[] tree;

        public segmentTree(int size) {
            tree = new int[size * 4];
        }

        public int init(int node, int start, int end) {
            if (start == end) {
                return tree[node] = start;
            }
            int a = init(node * 2, start, (start + end) / 2);
            int b = init(node * 2 + 1, (start + end) / 2 + 1, end);
            return tree[node] = arr[a] < arr[b] ? a : b;
        }

        public int find(int node, int start, int end, int left, int right) {
            if (left > end || start > right) {
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

    static int n;
    static long[] arr;
    static segmentTree seg;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }

            arr = new long[n + 1];
            arr[0] = Long.MAX_VALUE;
            for (int i = 1; i < n + 1; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            seg = new segmentTree(n);
            seg.init(1, 1, n);

            ans = 0;
            solve(1, n);

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }

    private static void solve(int left, int right) {
        if (left > right) {
            return;
        }

        int idx = seg.find(1, 1, n, left, right);
        ans = Math.max(ans, arr[idx] * (right - left + 1));

        solve(left, idx - 1);
        solve(idx + 1, right);
    }

}