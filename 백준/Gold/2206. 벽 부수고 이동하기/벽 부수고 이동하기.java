import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, ans;
	static int[][] map;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static boolean[][][] visit;

	static class Node {
		int r, c, cnt, wall;

		Node(int r, int c, int cnt, int wall) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.wall = wall;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		visit = new boolean[n][m][2];
		ans = -1;
		bfs(0, 0);

		System.out.println(ans);

	}

	public static void bfs(int i, int j) {
		Queue<Node> queue = new LinkedList<>();

		queue.add(new Node(i, j, 1, 0));

		visit[i][j][0] = true;

		while(!queue.isEmpty()) {
			Node node = queue.poll();

			int newr = node.r;
			int newc = node.c;

			if(newr == n-1 && newc == m-1) {
				ans = node.cnt;
				return;
			}

			for(int k = 0; k < 4; k++) {
				int nr = newr + dr[k];
				int nc = newc + dc[k];

				if(nr >= 0 && nc >= 0 && nr < n && nc < m) {
					if(node.wall == 0 && !visit[nr][nc][0]) {
						if(map[nr][nc] == 1) {
							visit[nr][nc][1] = true;
							queue.add(new Node(nr, nc, node.cnt + 1, 1));
						}else {
							visit[nr][nc][0] = true;
							queue.add(new Node(nr, nc, node.cnt + 1, 0));
						}
					}else if(node.wall == 1 && !visit[nr][nc][1]) {
						if(map[nr][nc] == 0) {
							visit[nr][nc][1] = true;
							queue.add(new Node(nr, nc, node.cnt + 1, node.wall));
						}
					}
				}
			}
		}
	}
}