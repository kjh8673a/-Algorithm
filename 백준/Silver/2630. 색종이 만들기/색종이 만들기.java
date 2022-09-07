import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] board;
	static int n, whiteCnt, blueCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		board = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		whiteCnt = 0;
		blueCnt = 0;

		cut(0, 0, n);

		System.out.println(whiteCnt);
		System.out.println(blueCnt);
	}

	public static void cut(int x, int y, int size) {
		int start = board[x][y];
		boolean isOneColor = true;
		loop: for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (board[i][j] != start) {
					isOneColor = false;
					break loop;
				}
			}
		}

		if (isOneColor) {
			if (start == 0)
				whiteCnt++;
			else
				blueCnt++;
			return;
		} else {
			cut(x, y, size / 2);
			cut(x + size / 2, y, size / 2);
			cut(x, y + size / 2, size / 2);
			cut(x + size / 2, y + size / 2, size / 2);
		}
	}

}