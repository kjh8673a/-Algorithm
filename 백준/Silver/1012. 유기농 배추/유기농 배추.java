import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int[][] field;
	static int m, n, k;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for(int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
	
			field = new int[n][m];

			for(int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				field[y][x] = 1;
			}

			visited = new boolean[n][m];

			int cnt = 0;

			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(field[i][j] == 1 && !visited[i][j]) {
						solve(i, j);
						cnt++;
					}
				}
			}

			sb.append(cnt).append("\n");
		}

		System.out.println(sb.toString());		

	}

	public static void solve(int x, int y) {
		visited[x][y] = true;

		for(int k = 0; k < 4; k++) {
			int nr = dr[k] + x;
			int nc = dc[k] + y;

			if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
				if(field[nr][nc] == 1 && !visited[nr][nc]) {
					solve(nr, nc);
				}
			}
		}
			
	}

}