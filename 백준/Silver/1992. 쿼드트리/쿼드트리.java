import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] board;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = line.charAt(j) - '0';
			}
		}

		int num = check(0, 0, N);
		if (num != -1) {
			sb.append(num);
		} else {
			compression(0, 0, N);
		}

		System.out.println(sb.toString());
	}

	public static void compression(int r, int c, int len) {
		sb.append("(");

		int sec1 = check(r, c, len / 2);
		if (sec1 != -1) {
			sb.append(sec1);
		} else {
			compression(r, c, len / 2);
		}

		int sec2 = check(r, c + len / 2, len / 2);
		if (sec2 != -1) {
			sb.append(sec2);
		} else {
			compression(r, c + len / 2, len / 2);
		}

		int sec3 = check(r + len / 2, c, len / 2);
		if (sec3 != -1) {
			sb.append(sec3);
		} else {
			compression(r + len / 2, c, len / 2);
		}

		int sec4 = check(r + len / 2, c + len / 2, len / 2);
		if (sec4 != -1) {
			sb.append(sec4);
		} else {
			compression(r + len / 2, c + len / 2, len / 2);
		}

		sb.append(")");
	}

	public static int check(int r, int c, int len) {
		int num = board[r][c];
		for (int i = r; i < r + len; i++) {
			for (int j = c; j < c + len; j++) {
				if (board[i][j] != num) {
					return -1;
				}
			}
		}

		return num;
	}

}