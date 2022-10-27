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
		// 1의 개수를 세서 total에 저장해놓는다
		int total = 0;

		// 리스트에 1인것들의 위치 저장
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

		// dfs를 통해 외부 공기를 -1로 만든다
		visited = new boolean[N][M];
		dfs(0, 0);

		int ans = 0;
		// 리스트의 사이즈만큼 반복하면서 리스트 주위에 -1의 개수를 세어 2 이상이면
		// board 0으로 만들기, total에서 1빼기, list에서 해당 노드 제거
		// 해당 시간에 반복을 다 돌리고나서 dfs를 통해 외부 공기 -1로 만든다
		// total이 0이 될때까지 반복
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