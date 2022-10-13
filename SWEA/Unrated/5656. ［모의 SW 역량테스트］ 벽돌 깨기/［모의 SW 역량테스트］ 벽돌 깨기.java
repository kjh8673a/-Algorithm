import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N, W, H, ans;
	static int[][] map;
	static int[] ball;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ball = new int[N];
			ans = Integer.MAX_VALUE;
			put(0);

			sb.append("#" + tc + " " + ans).append("\n");

		}

		System.out.println(sb.toString());

	}

	public static void put(int cnt) {
		if (cnt == N) {
			play();
			return;
		}

		for (int i = 0; i < W; i++) {
			ball[cnt] = i;
			put(cnt + 1);
		}
	}

	public static void play() {
		int[][] tmp = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				tmp[i][j] = map[i][j];
			}
		}

		for (int i = 0; i < N; i++) {
			int dr = -1;
			int dc = ball[i];

			for (int j = 0; j < H; j++) {
				if (tmp[j][dc] != 0) {
					dr = j;
					break;
				}
			}

			if (dr == -1) {
				continue;
			}

			doBreak(dr, dc, tmp);
			goDown(tmp);
		}

		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (tmp[i][j] != 0) {
					cnt++;
				}
			}
		}

		ans = Math.min(ans, cnt);

	}

	public static void doBreak(int r, int c, int[][] tmp) {
		int val = tmp[r][c];
		tmp[r][c] = 0;

		for (int k = 0; k < 4; k++) {
			int nr = r;
			int nc = c;

			for (int i = 1; i < val; i++) {
				nr += dr[k];
				nc += dc[k];

				if (nr < 0 || nc < 0 || nr >= H || nc >= W) {
					break;
				}

				if (tmp[nr][nc] <= 1) {
					tmp[nr][nc] = 0;
				} else {
					doBreak(nr, nc, tmp);
				}
			}
		}
	}

	public static void goDown(int[][] tmp) {
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < W; i++) {
			for (int j = H - 1; j >= 0; j--) {
				if (tmp[j][i] != 0) {
					queue.add(tmp[j][i]);
					tmp[j][i] = 0;
				}
			}
			int h = H - 1;
			while (!queue.isEmpty()) {
				tmp[h--][i] = queue.poll();
			}
		}
	}

}