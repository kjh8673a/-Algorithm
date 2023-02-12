import java.io.*;
import java.util.*;

public class Main {
    static class SegmentTree {
        long[] tree;

        public SegmentTree(int size) {
            tree = new long[size * 4];
        }

        public long init(long[] arr, int node, int start, int end) {
            if (start == end) {
                return tree[node] = arr[start];
            } else {
                return tree[node] = init(arr, node * 2, start, (start + end) / 2)
                        + init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
            }
        }

        public void update(int node, int start, int end, int idx, long diff) {
            if (idx < start || idx > end) {
                return;
            } else {
                tree[node] += diff;

                if (start != end) {
                    update(node * 2, start, (start + end) / 2, idx, diff);
                    update(node * 2 + 1, (start + end) / 2 + 1, end, idx, diff);
                }
            }
        }

        public long print(int node, int start, int end, int left, int right) {
            if (left > end || right < start) {
                return 0;
            }

            if (left <= start && right >= end) {
                return tree[node];
            }

            return print(node * 2, start, (start + end) / 2, left, right)
                    + print(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
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
            arr[i] = Long.parseLong(br.readLine());
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
                seg.update(1, 1, N, b, c - arr[b]);
                arr[b] = c;
            } else {
                sb.append(seg.print(1, 1, N, b, (int) c) + "\n");
            }
        }

        System.out.println(sb);

    }

}