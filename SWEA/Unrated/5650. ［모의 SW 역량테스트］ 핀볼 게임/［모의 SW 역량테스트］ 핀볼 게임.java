import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, ans;
	static int[][] map, wormhole;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			wormhole = new int[11][4];
			boolean[] check = new boolean[11];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] >= 6 && map[i][j] <= 10) {
						if (!check[map[i][j]]) {
							wormhole[map[i][j]][0] = i;
							wormhole[map[i][j]][1] = j;
							check[map[i][j]] = true;
						} else {
							wormhole[map[i][j]][2] = i;
							wormhole[map[i][j]][3] = j;
						}
					}
				}
			}

			ans = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) {
						dfs(i, j, i, j, 1);
						dfs(i, j, i, j, 2);
						dfs(i, j, i, j, 3);
						dfs(i, j, i, j, 4);
					}

				}
			}

			sb.append("#" + tc + " " + ans).append("\n");

		}

		System.out.println(sb.toString());

	}

	public static void dfs(int sr, int sc, int r, int c, int type) {
		// 1:상, 2:하, 3:좌, 4:우
		int score = 0;
		int nr = r;
		int nc = c;
		int d = type;

		while (true) {
			nr += dr[d - 1];
			nc += dc[d - 1];

			if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
				score++;
				if (d == 1) {
					d = 2;
				} else if (d == 2) {
					d = 1;
				} else if (d == 3) {
					d = 4;
				} else if (d == 4) {
					d = 3;
				}
				continue;
			}

			if (nr == sr && nc == sc) {
				ans = Math.max(ans, score);
				return;
			}

			int ground = map[nr][nc];

			switch (ground) {
				case -1:
					ans = Math.max(ans, score);
					return;

				case 0:
					break;

				case 1:
					score++;
					if (d == 1) {
						d = 2;
					} else if (d == 2) {
						d = 4;
					} else if (d == 3) {
						d = 1;
					} else if (d == 4) {
						d = 3;
					}
					break;

				case 2:
					score++;
					if (d == 1) {
						d = 4;
					} else if (d == 2) {
						d = 1;
					} else if (d == 3) {
						d = 2;
					} else if (d == 4) {
						d = 3;
					}
					break;

				case 3:
					score++;
					if (d == 1) {
						d = 3;
					} else if (d == 2) {
						d = 1;
					} else if (d == 3) {
						d = 4;
					} else if (d == 4) {
						d = 2;
					}
					break;

				case 4:
					score++;
					if (d == 1) {
						d = 2;
					} else if (d == 2) {
						d = 3;
					} else if (d == 3) {
						d = 4;
					} else if (d == 4) {
						d = 1;
					}
					break;

				case 5:
					score++;
					if (d == 1) {
						d = 2;
					} else if (d == 2) {
						d = 1;
					} else if (d == 3) {
						d = 4;
					} else if (d == 4) {
						d = 3;
					}
					break;

				default:
					if (wormhole[ground][0] == nr && wormhole[ground][1] == nc) {
						nr = wormhole[ground][2];
						nc = wormhole[ground][3];
					} else {
						nr = wormhole[ground][0];
						nc = wormhole[ground][1];
					}
					break;

			}

		}

	}

}