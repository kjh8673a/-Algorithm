import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class SegmentTree {
        long[] tree;
        int treeSize;

        public SegmentTree(int arrSize) {
            // 트리의 높이
            int height = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
            // 트리의 노드 수
            this.treeSize = (int) Math.pow(2, height + 1);
            // 트리 배열 설정
            tree = new long[treeSize];
        }

        // 배열을 입력받은 후 트리 초기화
        public long init(long[] arr, int node, int start, int end) {
            // 리프노드에 값을 넣고 반환한다
            if (start == end) {
                return tree[node] = arr[start];
            } else {
                // 리프노드가 아닌 경우 자식 노드로 들어간다
                return tree[node] = init(arr, node * 2, start, (start + end) / 2)
                        + init(arr, node * 2 + 1, (start + end) / 2 + 1, end);
            }
        }

        // 값이 변경될 경우 원래 배열의 값과 차이값을 더해준다
        public void update(int node, int start, int end, int idx, long diff) {
            // 구간에 idx가 포함되지 않는 경우
            if (idx < start || end < idx) {
                return;
            }

            // 구간 안에 idx가 포함될 경우 차이값을 더해준다
            tree[node] += diff;

            // 리프노드가 아닐경우 리프노드가 될때까지 탐색
            if (start != end) {
                update(node * 2, start, (start + end) / 2, idx, diff);
                update(node * 2 + 1, (start + end) / 2 + 1, end, idx, diff);
            }
        }

        // left ~ right 구간까지 합을 찾는다
        public long sum(int node, int start, int end, int left, int right) {
            // 구간에 포함되지 않을 경우
            if (left > end || right < start) {
                return 0;
            }

            // 구하려고 하는 구간에 노드의 구간이 포함되어 있을 경우
            if (left <= start && end <= right) {
                return tree[node];
            }

            // 그 외의 경우 자식노드를 탐색
            return sum(node * 2, start, (start + end) / 2, left, right)
                    + sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
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
                long ans = seg.sum(1, 1, N, b, (int) c);
                sb.append(ans + "\n");
            }
        }

        System.out.println(sb.toString());

    }

}