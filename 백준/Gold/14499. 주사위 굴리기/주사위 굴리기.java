import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, x, y, K;
	static int[][] board;
	static int[] moves, dice;
	static int[] dr = { 0, 0, 0, -1, 1 };
	static int[] dc = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		moves = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			moves[i] = Integer.parseInt(st.nextToken());
		}

		dice = new int[7];
		doDice(x, y, 0);

	}

	public static void doDice(int r, int c, int idx) {
		if (idx >= K) {
			return;
		}

		// 동: 1, 서: 2, 북: 3, 남: 4
		int move = moves[idx];

		int nr = r + dr[move];
		int nc = c + dc[move];

		if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
			doDice(r, c, idx + 1);
			return;
		}
		int one = dice[1];
		int two = dice[2];
		int three = dice[3];
		int four = dice[4];
		int five = dice[5];
		int six = dice[6];

		switch (move) {
			case 1:
				dice[1] = four;
				dice[3] = one;
				dice[4] = six;
				dice[6] = three;
				break;

			case 2:
				dice[1] = three;
				dice[3] = six;
				dice[4] = one;
				dice[6] = four;
				break;

			case 3:
				dice[1] = five;
				dice[2] = one;
				dice[5] = six;
				dice[6] = two;
				break;

			case 4:
				dice[1] = two;
				dice[2] = six;
				dice[5] = one;
				dice[6] = five;
				break;
		}

		if (board[nr][nc] == 0) {
			board[nr][nc] = dice[6];
		} else {
			dice[6] = board[nr][nc];
			board[nr][nc] = 0;
		}

		System.out.println(dice[1]);
		doDice(nr, nc, idx + 1);
	}

}