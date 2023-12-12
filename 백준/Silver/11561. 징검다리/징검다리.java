import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            long n = Long.parseLong(br.readLine());

            long left = 1;
            long right = Integer.MAX_VALUE;

            long answer = 1;
            while (left <= right) {
                // 몇개의 징검다리를 밟을지
                long mid = (left + right) / 2;

                // 1부터 mid까지 합
                long sum = mid * (mid + 1) / 2;
                if (sum <= n) {
                    answer = Math.max(answer, mid);
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

}