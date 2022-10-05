import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	/*
	 * 계단오르기 - DP
	 * 계단 세개 연속으로 밟을 수 없다
	 * 마지막 계단은 밟아야 한다 ==> 목적지가 마지막 계단
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 계단의 개수
		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n+1];
		int[] arr = new int[n+1];
		for (int i = 1; i < n+1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		// 시작점
		dp[1] = arr[1];

		// n의 값이 1이면 dp[0]만 입력한다
		if (n != 1) {
			dp[2] = arr[2] + arr[1];
		}

		for (int i = 3; i <= n; i++) {
			// 바로 전 계단(i-1)에서 올라왔으면 (i-2)번째 값을 빼준다
			dp[i] = Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i];
		}

		System.out.println(dp[n]);

	}

}