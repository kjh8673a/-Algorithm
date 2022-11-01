import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, ans;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				solve(i, j);
			}
		}

		System.out.println(ans);

	}

	public static void solve(int r, int c) {
		int max = 0;

		// 1 * 4 블럭
		if (c + 4 <= M) {
			int sum = 0;
			for (int i = c; i < c + 4; i++) {
				sum += map[r][i];
			}
			max = Math.max(sum, max);
		}

		// 2 * 3 블럭
		if (c + 3 <= M && r + 2 <= N) {
			int sum = 0;
			for (int i = r; i < r + 2; i++) {
				for (int j = c; j < c + 3; j++) {
					sum += map[i][j];
				}
			}

			int[] twoThree = {
					sum - map[r][c] - map[r][c + 1],
					sum - map[r + 1][c] - map[r + 1][c + 1],
					sum - map[r][c + 1] - map[r][c + 2],
					sum - map[r + 1][c + 1] - map[r + 1][c + 2],
					sum - map[r][c] - map[r + 1][c + 2],
					sum - map[r + 1][c] - map[r][c + 2],
					sum - map[r][c] - map[r][c + 2],
					sum - map[r + 1][c] - map[r + 1][c + 2]
			};

			for (int i = 0; i < 8; i++) {
				max = Math.max(max, twoThree[i]);
			}
		}

		// 2 * 2 블럭
		if (c + 2 <= M && r + 2 <= N) {
			int sum = 0;
			for (int i = r; i < r + 2; i++) {
				for (int j = c; j < c + 2; j++) {
					sum += map[i][j];
				}
			}
			max = Math.max(max, sum);
		}

		// 3 * 2 블럭
		if (c + 2 <= M && r + 3 <= N) {
			int sum = 0;
			for (int i = r; i < r + 3; i++) {
				for (int j = c; j < c + 2; j++) {
					sum += map[i][j];
				}
			}

			int[] threeTwo = {
					sum - map[r][c + 1] - map[r + 1][c + 1],
					sum - map[r][c] - map[r + 1][c],
					sum - map[r + 1][c + 1] - map[r + 2][c + 1],
					sum - map[r + 1][c] - map[r + 2][c],
					sum - map[r][c + 1] - map[r + 2][c],
					sum - map[r][c] - map[r + 2][c + 1],
					sum - map[r][c + 1] - map[r + 2][c + 1],
					sum - map[r][c] - map[r + 2][c]
			};

			for (int i = 0; i < 8; i++) {
				max = Math.max(max, threeTwo[i]);
			}
		}

		// 4 * 1 블럭
		if (r + 4 <= N) {
			int sum = 0;
			for (int i = r; i < r + 4; i++) {
				sum += map[i][c];
			}
			max = Math.max(sum, max);
		}

		ans = Math.max(ans, max);

	}

}