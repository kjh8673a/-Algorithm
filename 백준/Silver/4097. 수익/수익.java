import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n;
        StringBuilder sb = new StringBuilder();
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            int[] dp = new int[n + 1];

            int answer = Integer.MIN_VALUE;
            for (int i = 1; i < n + 1; i++) {
                int p = Integer.parseInt(br.readLine());
                dp[i] = Math.max(dp[i - 1] + p, p);
                answer = Math.max(dp[i], answer);
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

}