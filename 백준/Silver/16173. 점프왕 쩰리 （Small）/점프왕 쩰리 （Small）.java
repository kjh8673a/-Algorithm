import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0 });
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        boolean flag = false;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int jump = board[node[0]][node[1]];

            if (node[0] == n - 1 && node[1] == n - 1) {
                flag = true;
                break;
            }

            if (node[0] + jump < n && node[1] < n && !visited[node[0] + jump][node[1]]) {
                queue.add(new int[] { node[0] + jump, node[1] });
                visited[node[0] + jump][node[1]] = true;
            }

            if (node[0] < n && node[1] + jump < n && !visited[node[0]][node[1] + jump]) {
                queue.add(new int[] { node[0], node[1] + jump });
                visited[node[0]][node[1] + jump] = true;
            }
        }

        System.out.println(flag ? "HaruHaru" : "Hing");
    }

}