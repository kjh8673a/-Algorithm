import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int num;
        String path;

        public Node(int num, String path) {
            this.num = num;
            this.path = path;
        }
    }

    static String ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ans = "";

            bfs(a, b);

            sb.append(ans).append("\n");
        }

        System.out.println(sb.toString());

    }

    public static void bfs(int start, int end) {
        Queue<Node> queue = new LinkedList<>();

        boolean[] visit = new boolean[10000];

        queue.add(new Node(start, ""));
        visit[start] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int num = node.num;
            String path = node.path;

            if(!ans.isEmpty() && ans.length() < path.length()) {
                return;
            }

            if(num == end) {
                ans = path;
                return;
            }

            // D
            int nextD = (num * 2) % 10000;
            if(!visit[nextD]) {
                visit[nextD] = true;
                queue.add(new Node(nextD, path + "D"));
            }

            // S
            int nextS = num - 1;
            if(nextS == -1) {
                nextS = 9999;
            }
            if(!visit[nextS]) {
                visit[nextS] = true;
                queue.add(new Node(nextS, path + "S"));
            }

            int d4 = num % 10;
            int d3 = (num / 10) % 10;
            int d2 = (num / 100) % 10;
            int d1 = num / 1000;

            // L
            int nextL = ((d2 * 10 + d3) * 10 + d4) * 10 + d1;
            if(!visit[nextL]) {
                visit[nextL] = true;
                queue.add(new Node(nextL, path + "L"));
            }

            // R
            int nextR = ((d4 * 10 + d1) * 10 + d2) * 10 + d3;
            if(!visit[nextR]) {
                visit[nextR] = true;
                queue.add(new Node(nextR, path + "R"));
            }

        }
    }

}