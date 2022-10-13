import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] dr = { 1, -1, -1, 1 };
	static int[] dc = { 1, 1, -1, -1 };
	static int[][] map;
	static boolean[][] visit;
	static boolean[] dessert;
	static int N, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			visit = new boolean[N][N];
			dessert = new boolean[101];
			ans = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if ((i == 0 && j == 0) || (i == 0 && j == N - 1) || (i == N - 1 && j == 0)
							|| (i == N - 1 && j == N - 1)) {
						continue;
					}
					visit[i][j] = true;
					dessert[map[i][j]] = true;
					dfs(i, j, i, j, 1, 0);
					visit[i][j] = false;
					dessert[map[i][j]] = false;
				}
			}

			sb.append("#" + tc + " " + ans).append("\n");

		}

		System.out.println(sb.toString());

	}

	public static void dfs(int start_r, int start_c, int r, int c, int cnt, int dir) {
		for (int k = dir; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];

			if (nr == start_r && nc == start_c && cnt >= 4) {
				ans = Math.max(ans, cnt);
				return;
			}

			if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
				continue;
			}

			if (!visit[nr][nc] && !dessert[map[nr][nc]]) {

				visit[nr][nc] = true;
				dessert[map[nr][nc]] = true;
				dfs(start_r, start_c, nr, nc, cnt + 1, k);
				visit[nr][nc] = false;
				dessert[map[nr][nc]] = false;
			}
		}

	}

}