import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int R, C, ans;
	static Character[][] board;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new Character[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		ans = 0;

		visit = new boolean[26];
		int num = board[0][0] - 'A';
		visit[num] = true;

		dfs(0, 0, 1);

		System.out.println(ans);
	}

	public static void dfs(int r, int c, int len) {

		boolean moveon = false;
		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];

			if (nr < 0 || nc < 0 || nr >= R || nc >= C) {
				continue;
			}

			int num = board[nr][nc] - 'A';
			if (!visit[num]) {
				visit[num] = true;
				moveon = true;
				dfs(nr, nc, len + 1);
				visit[num] = false;
			}
		}

		if (!moveon) {
			ans = Math.max(ans, len);
		}
	}

}