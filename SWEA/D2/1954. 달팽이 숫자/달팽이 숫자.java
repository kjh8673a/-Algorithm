import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int direction, nowX, nowY;
	static int[][] board;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {

			n = Integer.parseInt(br.readLine());

			board = new int[n][n];

			direction = 1;

			nowX = 0;
			nowY = 0;

			for (int i = 1; i <= n * n; i++) {
				snail(i);
			}

			sb.append("#" + tc).append("\n");

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sb.append(board[i][j] + " ");
				}
				sb.append("\n");
			}

		}

		System.out.println(sb.toString());

	}

	public static void snail(int num) {
		board[nowX][nowY] = num;

		if (num == n * n) {
			return;
		}

		switch (direction) {
			case 1:
				if (nowY + 1 >= n || board[nowX][nowY + 1] != 0) {
					direction = 2;
					nowX++;
					break;
				}
				nowY++;
				break;

			case 2:
				if (nowX + 1 >= n || board[nowX + 1][nowY] != 0) {
					direction = 3;
					nowY--;
					break;
				}
				nowX++;
				break;

			case 3:
				if (nowY - 1 < 0 || board[nowX][nowY - 1] != 0) {
					direction = 4;
					nowX--;
					break;
				}
				nowY--;
				break;

			case 4:
				if (nowX - 1 < 0 || board[nowX - 1][nowY] != 0) {
					direction = 1;
					nowY++;
					break;
				}
				nowX--;
				break;
		}

	}

}