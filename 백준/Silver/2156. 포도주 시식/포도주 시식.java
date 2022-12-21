import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] wine = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}

		int ans = 0;
		int[] dp = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			if (i <= 2) {
				dp[i] = dp[i - 1] + wine[i];
			} else {
				// i-1을 먹었다면 i-2를 빼주자
				// 아니면 현재 보고있는거를 먹지 않던가
				dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 3] + wine[i - 1], dp[i - 2]) + wine[i]);
			}
			// 마지막꺼를 먹는것이 정답이 아닐수도있다
			// 최대값을 갱신하면서 가자
			if (dp[i] > ans) {
				ans = dp[i];
			}
		}

		System.out.println(ans);
	}

}