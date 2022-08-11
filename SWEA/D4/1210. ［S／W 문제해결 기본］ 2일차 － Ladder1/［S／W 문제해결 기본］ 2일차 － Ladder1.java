import java.util.Scanner;

public class Solution {
	static int ans;
	static boolean[][] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 0; tc < 10; tc++) {
			int n = sc.nextInt();

			int[][] board = new int[100][100];

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					board[i][j] = sc.nextInt();
				}
			}

			int goal = 0;
			for (int i = 0; i < 100; i++) {
				if (board[99][i] == 2) {
					goal = i;
					break;
				}
			}

			check = new boolean[100][100];
			ladder(board, 99, goal);

			System.out.println("#" + n + " " + ans);
		}

		sc.close();
	}

	public static void ladder(int[][] arr, int x, int y) {
		check[x][y] = true;

		if (x == 0) {
			ans = y;
			return;
		}

		if (y - 1 >= 0 && arr[x][y - 1] == 1 && !check[x][y - 1]) {
			ladder(arr, x, y - 1);
		} else if (y + 1 < 100 && arr[x][y + 1] == 1 && !check[x][y + 1]) {
			ladder(arr, x, y + 1);
		} else {
			ladder(arr, x - 1, y);
		}
	}
}