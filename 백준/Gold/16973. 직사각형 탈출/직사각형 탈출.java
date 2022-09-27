import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, h, w, sr, sc, fr, fc, ans;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static class Node {
		int r, c, cnt;

		Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
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

		st = new StringTokenizer(br.readLine());
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		sr = Integer.parseInt(st.nextToken()) - 1;
		sc = Integer.parseInt(st.nextToken()) - 1;
		fr = Integer.parseInt(st.nextToken()) - 1;
		fc = Integer.parseInt(st.nextToken()) - 1;

		visit = new boolean[n][m];
		ans = -1;
		bfs(sr, sc);

		System.out.println(ans);

	}

	public static void bfs(int i, int j) {
		Queue<Node> queue = new LinkedList<>();

		queue.add(new Node(i, j, 0));

		visit[i][j] = true;

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			int newr = node.r;
			int newc = node.c;

			if (newr == fr && newc == fc) {
				ans = node.cnt;
				return;
			}

			for (int k = 0; k < 4; k++) {
				int nr = newr + dr[k];
				int nc = newc + dc[k];

				if (nr >= 0 && nc >= 0 && nr + h - 1 < n && nc + w - 1 < m) {
					if (!visit[nr][nc] && noWall(nr, nc)) {
						visit[nr][nc] = true;
						queue.add(new Node(nr, nc, node.cnt + 1));
					}
				}
			}
		}
	}

	public static boolean noWall(int x, int y) {
		for (int i = x; i < x + h; i++) {
			for (int j = y; j < y + w; j++) {
				if (map[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}
}