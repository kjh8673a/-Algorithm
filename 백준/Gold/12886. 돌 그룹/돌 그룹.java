import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if ((a + b + c) % 3 != 0) {
            System.out.println(0);
        } else {
            boolean possible = bfs(a, b, c);

            System.out.println(possible ? 1 : 0);
        }
    }

    private static boolean bfs(int a, int b, int c) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[1501][1501];

        queue.add(new int[] { a, b, c });
        queue.add(new int[] { b, c, a });
        queue.add(new int[] { c, a, b });

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            if (node[0] == node[1] && node[1] == node[2]) {
                return true;
            }

            int x = Math.min(node[0], node[1]);
            int y = Math.max(node[0], node[1]);
            int na = x + x;
            int nb = y - x;

            if (!visited[na][nb]) {
                visited[na][nb] = true;
                queue.add(new int[] { na, nb, node[2] });
                queue.add(new int[] { nb, node[2], na });
                queue.add(new int[] { node[2], na, nb });
            }
        }

        return false;
    }

}