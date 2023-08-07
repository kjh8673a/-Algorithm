import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int min;
        int max;

        public Node(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    static class SegmentTree {
        Node[] tree;

        public SegmentTree(int arrSize) {
            tree = new Node[arrSize * 4];
        }

        public Node init(int[] arr, int node, int start, int end) {
            if (start == end) {
                return tree[node] = new Node(arr[start], arr[start]);
            } else {
                Node a = init(arr, node * 2, start, (start + end) / 2);
                Node b = init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
                return tree[node] = new Node(Math.min(a.min, b.min), Math.max(a.max, b.max));
            }
        }

        public Node find(int node, int start, int end, int left, int right) {
            if (left > end || right < start) {
                return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE);
            }

            if (left <= start && end <= right) {
                return tree[node];
            }

            Node a = find(node * 2, start, (start + end) / 2, left, right);
            Node b = find(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
            return new Node(Math.min(a.min, b.min), Math.max(a.max, b.max));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        SegmentTree seg = new SegmentTree(N);
        seg.init(arr, 1, 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            Node node = seg.find(1, 1, N, left, right);
            sb.append(node.min + " " + node.max).append("\n");
        }

        System.out.println(sb);
    }

}