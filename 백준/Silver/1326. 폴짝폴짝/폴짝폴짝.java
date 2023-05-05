import java.io.*;
import java.util.*;

public class Main {
    static int N, ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        ans = -1;
        bfs(from, to);
        System.out.println(ans);
    }

    static class Node {
        int num;
        int cnt;

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void bfs(int a, int b) {
        boolean[] visit = new boolean[N + 1];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(a, 0));
        visit[a] = true;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int num = node.num;
            int cnt = node.cnt;

            if (num == b) {
                ans = cnt;
                return;
            }

            int next = num;
            while(true) {
                next += arr[num];
                if(next > N) {
                    break;
                }

                if(!visit[next]) {
                    visit[next] = true;
                    queue.add(new Node(next, cnt + 1));
                }
            }

            next = num;
            while(true) {
                next -= arr[num];
                if(next < 1) {
                    break;
                }
                if(!visit[next]) {
                    visit[next] = true;
                    queue.add(new Node(next, cnt + 1));
                }
            }
        
        }
    }
}
