import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());

            Node[] list = new Node[n + 2];

            for (int i = 0; i < n + 2; i++) {
                st = new StringTokenizer(br.readLine());
                list[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            Queue<Node> queue = new LinkedList<>();
            boolean[] visit = new boolean[n + 2];

            queue.add(list[0]);
            visit[0] = true;

            boolean isPossible = false;

            loop: 
            while (!queue.isEmpty()) {
                Node node = queue.poll();

                int r = node.r;
                int c = node.c;

                for (int j = 1; j < n + 2; j++) {
                    if (!visit[j]) {
                        Node next = list[j];
                        int nr = next.r;
                        int nc = next.c;
                        if (Math.abs(nr - r) + Math.abs(nc - c) <= 1000) {
                            visit[j] = true;
                            queue.add(new Node(nr, nc));
                            if (j == n + 1) {
                                isPossible = true;
                                break loop;
                            }
                        }
                    }
                }
            }

            if (isPossible) {
                sb.append("happy").append("\n");
            } else {
                sb.append("sad").append("\n");
            }

        }

        System.out.println(sb.toString());
    }

}