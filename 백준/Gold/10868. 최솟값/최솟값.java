import java.util.*;
import java.io.*;

public class Main {
    static class SegmentTree {
        int[] tree;
        int treeSize;

        public SegmentTree(int arrSize) {
            int height = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
            this.treeSize = (int) Math.pow(2, height + 1);
            tree = new int[treeSize];
        }

        public int init(int[] arr, int node, int start, int end) {
            if (start == end) {
                return tree[node] = start;
            } else {
                int a = init(arr, node * 2, start, (start + end) / 2);
                int b = init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
                return tree[node] = arr[a] < arr[b] ? a : b;
            }
        }

        public int find(int[] arr, int node, int start, int end, int left, int right) {
            if (left > end || right < start) {
                return 0;
            }

            if (left <= start && end <= right) {
                return tree[node];
            }

            int a = find(arr, node * 2, start, (start + end) / 2, left, right);
            int b = find(arr, node * 2 + 1, (start + end) / 2 + 1, end, left, right);
            return arr[a] < arr[b] ? a : b;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        arr[0] = Integer.MAX_VALUE;

        SegmentTree seg = new SegmentTree(N);
        seg.init(arr, 1, 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int idx = seg.find(arr, 1, 1, N, Math.min(a, b), Math.max(a, b));
            sb.append(arr[idx]).append("\n");
        }

        System.out.println(sb);
    }
}