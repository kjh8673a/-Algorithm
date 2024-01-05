import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        System.out.println(bfs(T, A, B));
    }

    static class Node {
        int fullness;
        int water;

        public Node(int fullness, int water) {
            this.fullness = fullness;
            this.water = water;
        }
    }

    private static int bfs(int t, int a, int b) {
        int answer = 0;

        boolean[][] visited = new boolean[t + 1][2];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            answer = Math.max(curr.fullness, answer);

            if (curr.fullness + a <= t && !visited[curr.fullness + a][curr.water]) {
                queue.add(new Node(curr.fullness + a, curr.water));
                visited[curr.fullness + a][curr.water] = true;
            }

            if (curr.fullness + b <= t && !visited[curr.fullness + b][curr.water]) {
                queue.add(new Node(curr.fullness + b, curr.water));
                visited[curr.fullness + b][curr.water] = true;
            }

            if (curr.water == 0 && !visited[curr.fullness / 2][1]) {
                queue.add(new Node(curr.fullness / 2, 1));
                visited[curr.fullness / 2][1] = true;
            }
        }

        return answer;
    }

}