import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Node[] point = new Node[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            point[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int[] dist = new int[N - 1];
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            dist[i] = getDistance(point, i, i + 1);
            sum += dist[i];
        }

        int ans = sum;
        for (int i = 1; i < N - 1; i++) {
            int tmp = sum - dist[i - 1] - dist[i];
            tmp += getDistance(point, i - 1, i + 1);
            ans = Math.min(ans, tmp);
        }

        System.out.println(ans);
    }

    private static int getDistance(Node[] point, int i, int j) {
        return Math.abs(point[i].x - point[j].x) + Math.abs(point[i].y - point[j].y);
    }

}
