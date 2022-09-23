import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int n, cnt;
	static boolean[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		int[][] board = new int[n][n];

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, board[i][j]);
				min = Math.min(min, board[i][j]);
			}
		}

		int ans = 0;
		for (int t = min-1; t <= max; t++) {

			map = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] > t) {
						map[i][j] = true;
					}
				}
			}

			cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if(map[i][j]) {
						dfs(i, j);
						cnt++;
					}
				}
			}

			ans = Math.max(ans, cnt);
		}

		System.out.println(ans);

	}

	public static void dfs(int x, int y) {
		map[x][y] = false;

		for(int i = 0; i < 4; i++) {
			int nr = x + dr[i];
			int nc = y + dc[i];

			if(nr >= 0 && nc >= 0 && nr < n && nc < n) {
				if(map[nr][nc]) {
					dfs(nr, nc);
				}
			}
		}
	}
}