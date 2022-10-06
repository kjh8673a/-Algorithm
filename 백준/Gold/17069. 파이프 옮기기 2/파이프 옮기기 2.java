import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[][] board = new int[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n + 1; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 0 --> 가로 / 1 --> 세로 / 2 --> 대각선
		// 파이프 끝점을 저장 방향까지
		long[][][] dp = new long[n + 1][n + 1][3];
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (board[i][j] != 1) {
					// 가로로 놓이는 경우
					dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
					// 세로로 놓이는 경우
					dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
					// 대각선으로 놓이는 경우
					if (board[i - 1][j] != 1 && board[i][j - 1] != 1) {
						dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
					}
				}
				if (i == 1 && j == 2) {
					dp[i][j][0] = 1;
				}
			}
		}

		long ans = dp[n][n][0] + dp[n][n][1] + dp[n][n][2];

		System.out.println(ans);

	}

}