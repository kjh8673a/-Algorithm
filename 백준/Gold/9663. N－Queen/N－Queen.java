import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static boolean[][] board;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		board = new boolean[n][n];
		ans = 0;

		putQueen(0);

		System.out.println(ans);

	}

	public static void putQueen(int r) {
		if (r == n) {
			ans++;
			return;
		}

		for (int c = 0; c < n; c++) {
			if (isPutable(r, c)) {
				board[r][c] = true;
				putQueen(r + 1);
				board[r][c] = false;
			}
		}
	}

	public static boolean isPutable(int r, int c) {
		for (int i = 0; i < r; i++) {
			if (board[i][c]) {
				return false;
			}

			int d = r - i;

			if (c - d >= 0 && board[r - d][c - d]) {
				return false;
			}

			if (c + d < n && board[r - d][c + d]) {
				return false;
			}
		}

		return true;
	}
}