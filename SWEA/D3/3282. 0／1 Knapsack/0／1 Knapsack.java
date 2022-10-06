import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static class Node {
        int volume, cost;

        public Node(int volume, int cost) {
            this.volume = volume;
            this.cost = cost;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            // 물건의 개수 n
            int n = Integer.parseInt(st.nextToken());
            // 가방의 부피 k
            int k = Integer.parseInt(st.nextToken());

            Node[] list = new Node[n + 1];

            for (int i = 1; i < n + 1; i++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                list[i] = new Node(v, c);
            }

            int[][] dp = new int[n + 1][k + 1];

            // 물건의 번호 i
            for (int i = 1; i < n + 1; i++) {
                // 물건별로 모든 부피(j)에 대해 최적해를 구한다
                int volume = list[i].volume;
                int cost = list[i].cost;
                for (int j = 0; j < k + 1; j++) {
                    // 현재 물건을 넣을 수 있다면(부피 여유가 있다)
                    if (volume <= j) {
                        // j에 대해 이전에 구한 최적해 VS
                        // 현재 물건을 넣기 전 부피의 최적해 + 현재 물건 가치
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - volume] + cost);
                    }
                    // 넣을 수 없다면(부피 초과)
                    else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            sb.append("#" + tc + " " + dp[n][k]).append("\n");

        }

        System.out.println(sb.toString());

    }
}