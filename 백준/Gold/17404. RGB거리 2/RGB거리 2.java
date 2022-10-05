import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	/*
	 * RGB거리2 - DP
	 * RGB거리문제 + 1번과 N번의 색깔이 다르다
	 * 첫집의 RGB 중 하나 선택, 나머지는 큰 값으로 지정
	 * N번집까지 가서 첫번째에서 선택한 번호 말고 나머지 두개 값 비교
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] dp = new int[n][3];
		int[][] arr = new int[n][3];
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}

		int ans = Integer.MAX_VALUE;
		for(int k = 0; k < 3; k++) {
			dp[0][0] = 100000000;
			dp[0][1] = 100000000;
			dp[0][2] = 100000000;
			
			// 첫집의 색깔로 k번 색깔을 선택하겠다
			// 선택안한 집은 매우 큰값
			dp[0][k] = arr[0][k];

			for(int i = 1; i < n; i++) {
				dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
				dp[i][1] = Math.min(dp[i-1][2], dp[i-1][0]) + arr[i][1];
				dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
			}

			// 1번집 색깔로 k번 색깔을 선택했으므로
			// k번 배열에 매우 큰 값을 주고 비교한다
			dp[n-1][k] = 100000000;
			int now = Math.min(Math.min(dp[n-1][0], dp[n-1][1]), dp[n-1][2]);
			
			ans = Math.min(ans, now);
		}

		System.out.println(ans);
		
	}

}