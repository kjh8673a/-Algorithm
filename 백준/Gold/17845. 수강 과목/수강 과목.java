import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int value;
        int cost;

        public Node(int value, int cost) {
            this.value = value;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Node[] list = new Node[k + 1];
        for (int i = 1; i < k + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[i] = new Node(v, c);
        }

        int[][] dp = new int[k + 1][n + 1];
        for (int i = 1; i < k + 1; i++) {
            int value = list[i].value;
            int cost = list[i].cost;
            for (int j = 0; j < n + 1; j++) {
                if (j >= cost) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost] + value);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[k][n]);
    }

}