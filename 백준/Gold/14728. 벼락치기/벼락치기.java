import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int time, score;

        public Node(int time, int score) {
            this.time = time;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        Node[] list = new Node[N + 1];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[i] = new Node(a, b);
        }

        int[][] dp = new int[N + 1][T + 1];
        for (int i = 1; i < N + 1; i++) {
            int time = list[i].time;
            int score = list[i].score;

            for (int j = 0; j < T + 1; j++) {
                if (time <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - time] + score);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N][T]);

    }

}