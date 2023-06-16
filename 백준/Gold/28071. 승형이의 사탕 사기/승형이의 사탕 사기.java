import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int candy;
        int box;

        public Node(int candy, int box) {
            this.candy = candy;
            this.box = box;
        }
    }

    static int N, M, K, max, ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        ans = 0;
        bfs();

        System.out.println(ans);
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visit = new boolean[max * M + 1];

        for (int i = 0; i < N; i++) {
            queue.add(new Node(arr[i], 1));
            visit[arr[i]] = true;
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.candy % K == 0) {
                ans = Math.max(node.candy, ans);
            }

            if (node.box == M) {
                continue;
            }

            for (int i = 0; i < N; i++) {
                int nCandy = node.candy + arr[i];
                int nBox = node.box + 1;
                if (!visit[nCandy]) {
                    visit[nCandy] = true;
                    queue.add(new Node(nCandy, nBox));
                }
            }
        }

    }

}
