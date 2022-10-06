import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map, dp;
	static int n, m;
	static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visit = new boolean[n][m];
		dp = new int[n][m];
		dp[0][0] = 1;
		System.out.println(method(n - 1, m - 1));

	}

	public static int method(int r, int c) {
		if(!visit[r][c]) {
			if (c + 1 < m && map[r][c] < map[r][c + 1]) {
				dp[r][c] += method(r, c + 1);
			}

			if (r - 1 >= 0 && map[r][c] < map[r - 1][c]) {
				dp[r][c] += method(r - 1, c);
			}
			
			if (c - 1 >= 0 && map[r][c] < map[r][c - 1]) {
				dp[r][c] += method(r, c - 1);
			}
			if(r + 1 < n && map[r][c] < map[r + 1][c]) {
				dp[r][c] += method(r + 1, c);
			}
			visit[r][c] = true;
		}
		
		return dp[r][c];
	}

}