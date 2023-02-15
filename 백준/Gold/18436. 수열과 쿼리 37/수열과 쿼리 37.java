import java.io.*;
import java.util.*;

public class Main {
    static class SegmentTree {
        int[] tree;

        public SegmentTree(int arrSize) {
            tree = new int[arrSize * 4];
        }

        public int init(int[] arr, int node, int start, int end) {
            if (start == end) {
                return tree[node] = arr[start];
            } else {
                return tree[node] = init(arr, node * 2, start, (start + end) / 2)
                        + init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
            }
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

        public int count(int node, int start, int end, int left, int right) {
            if (left > end || right < start) {
                return 0;
            }

            if (left <= start && end <= right) {
                return tree[node];
            }

            return count(node * 2, start, (start + end) / 2, left, right)
                    + count(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = (Integer.parseInt(st.nextToken()) % 2 == 0 ? 0 : 1);
        }

        SegmentTree seg = new SegmentTree(N);
        seg.init(arr, 1, 1, N);

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int d = (c % 2 == 0 ? 0 : 1);

            switch (a) {
                case 1:
                    if (arr[b] != d) {
                        seg.update(1, 1, N, b, d - arr[b]);
                        arr[b] = d;
                    }
                    break;
                case 2:
                    sb.append((c - b + 1) - seg.count(1, 1, N, b, c) + "\n");
                    break;
                case 3:
                    sb.append(seg.count(1, 1, N, b, c) + "\n");
                    break;
            }
        }

        System.out.println(sb);

    }

}