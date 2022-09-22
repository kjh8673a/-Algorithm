import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	static int ans;
	static int newr, newc;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		board = new int[10][10];

		int rs = -1;
		int cs = -1;

		int total = 0;

		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (rs == -1 && board[i][j] == 1) {
					rs = i;
					cs = j;
				}
				if (board[i][j] == 1) {
					total++;
				}
			}
		}

		ans = Integer.MAX_VALUE;

		put(0, 0, 0, 0, 0, rs, cs, total);

		if (ans == Integer.MAX_VALUE) {
			ans = -1;
		}

		System.out.println(ans);

	}

	public static void put(int a, int b, int c, int d, int e, int rs, int cs, int tot) {
		if (a > 5 || b > 5 || c > 5 || d > 5 || e > 5) {
			return;
		}

		if (a + b + c + d + e >= ans) {
			return;
		}

		if (tot == 0) {
			ans = Math.min(ans, a + b + c + d + e);
			return;
		}
		newr = 0;
		newc = 0;
		if (tot >= 25 && rs <= 5 && cs <= 5) {
			if (isPutable(rs, cs, 5)) {
				change(rs, cs, 5, 0);
				findOne(rs, cs);
				put(a, b, c, d, e + 1, newr, newc, tot - 25);
				change(rs, cs, 5, 1);
			}
		}

		if (tot >= 16 && rs <= 6 && cs <= 6) {
			if (isPutable(rs, cs, 4)) {
				change(rs, cs, 4, 0);
				findOne(rs, cs);
				put(a, b, c, d + 1, e, newr, newc, tot - 16);
				change(rs, cs, 4, 1);
			}
		}

		if (tot >= 9 && rs <= 7 && cs <= 7) {
			if (isPutable(rs, cs, 3)) {
				change(rs, cs, 3, 0);
				findOne(rs, cs);
				put(a, b, c + 1, d, e, newr, newc, tot - 9);
				change(rs, cs, 3, 1);
			}
		}

		if (tot >= 4 && rs <= 8 && cs <= 8) {
			if (isPutable(rs, cs, 2)) {
				change(rs, cs, 2, 0);
				findOne(rs, cs);
				put(a, b + 1, c, d, e, newr, newc, tot - 4);
				change(rs, cs, 2, 1);
			}
		}

		if (isPutable(rs, cs, 1)) {
			change(rs, cs, 1, 0);
			findOne(rs, cs);
			put(a + 1, b, c, d, e, newr, newc, tot - 1);
			change(rs, cs, 1, 1);
		}

	}

	public static boolean isPutable(int r, int c, int n) {
		for (int i = r; i < r + n; i++) {
			for (int j = c; j < c + n; j++) {
				if (board[i][j] != 1) {
					return false;
				}
			}
		}

		return true;
	}

	public static void change(int r, int c, int n, int num) {
		for (int i = r; i < r + n; i++) {
			for (int j = c; j < c + n; j++) {
				board[i][j] = num;
			}
		}
	}

	public static void findOne(int r, int c) {
		for (int i = r; i < 10; i++) {
			for (int j = c; j < 10; j++) {
				if (j == 9) {
					c = 0;
				}
				if (board[i][j] == 1) {
					newr = i;
					newc = j;
					return;
				}
			}
		}
	}

}