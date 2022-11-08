import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] ans = new int[N];

        int cycle = N * 2 - 2;
        int totalMove = M / K;

        for (int i = 0; i < N; i++) {
            if (i == 0 || i == N - 1) {
                ans[i] += totalMove / cycle * K;
            } else {
                ans[i] += totalMove / cycle * K * 2;
            }
        }

        int left = totalMove % cycle;

        if (left >= N) {
            for (int i = 0; i < N; i++) {
                ans[i] += K;
            }
            left -= N;
            for (int i = N - 2; i > N - 2 - left; i--) {
                ans[i] += K;
            }
            if (M % K != 0) {
                ans[N - 2 - left] += M % K;
            }
        } else {
            for (int i = 0; i < left; i++) {
                ans[i] += K;
            }
            if (M % K != 0) {
                ans[left] += M % K;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(ans[i] + " ");
        }

        System.out.println(sb);
    }
}