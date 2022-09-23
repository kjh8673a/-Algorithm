import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { 0, 0, 1, -1, -1, 1, -1, 1 };
	static int[] dc = { 1, -1, 0, 0, -1, 1, 1, -1 };
	static int w, h, cnt;
	static boolean[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0) {
				break;
			}

			map = new boolean[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = (Integer.parseInt(st.nextToken()) == 1) ? true : false;
				}
			}

			cnt = 0;

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j]) {
						dfs(i, j);
						cnt++;
					}
				}
			}

			sb.append(cnt).append("\n");
		}

		System.out.println(sb.toString());
	}

	public static void dfs(int x, int y) {
		map[x][y] = false;

		for (int i = 0; i < 8; i++) {
			int nr = x + dr[i];
			int nc = y + dc[i];

			if (nr >= 0 && nc >= 0 && nr < h && nc < w) {
				if (map[nr][nc]) {
					dfs(nr, nc);
				}
			}
		}
	}

}