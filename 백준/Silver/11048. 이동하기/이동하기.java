import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] board = new int[n+1][m+1];
		for(int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < m+1; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// (1,1) -> (n, m)이동
		// (r+1, c), (r, c+1), (r+1, c+1) 이동 가능 --> 대각선은 꼭 가야할까?
		int[][] dp = new int[n+1][m+1];

		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < m+1; j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + board[i][j];
			}
		}

		System.out.println(dp[n][m]);

    }

}