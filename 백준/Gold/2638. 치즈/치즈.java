import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int r, c, time;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int N, M;
	static int[][] board;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		int total = 0;
		ArrayList<Node> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) {
					total++;
					list.add(new Node(i, j));
				}
			}
		}

		visited = new boolean[N][M];
		dfs(0, 0);

		int ans = 0;
		while (total != 0) {
			int len = list.size();
			for (int i = len - 1; i >= 0; i--) {
				Node node = list.get(i);
				int r = node.r;
				int c = node.c;

				if (nearZero(r, c) >= 2) {
					board[r][c] = 0;
					total--;
					list.remove(i);
				}
			}

			visited = new boolean[N][M];
			dfs(0, 0);
			ans++;
		}

		System.out.println(ans);

	}

	public static void dfs(int r, int c) {
		visited[r][c] = true;
		board[r][c] = -1;

		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];

			if (nr < 0 || nc < 0 || nr >= N || nc >= M || board[nr][nc] == 1 || visited[nr][nc]) {
				continue;
			}

			dfs(nr, nc);
		}
	}

	public static int nearZero(int r, int c) {
		int near = 0;
		for (int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if (board[nr][nc] == -1) {
				near++;
			}
		}
		return near;
	}

}