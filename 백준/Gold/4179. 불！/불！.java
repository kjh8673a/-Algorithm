import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, ans;
	static char[][] map;
	static boolean[][] visit;
	static Queue<Node> queue;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static class Node {
		int r, c, cnt;
		char type;

		Node(int r, int c, int cnt, char type) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.type = type;
		}
	}

	static Node first;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		visit = new boolean[n][m];
		queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);

				if (map[i][j] == 'J') {
					first = new Node(i, j, 0, 'J');
				}

				if(map[i][j] == 'F') {
					queue.add(new Node(i, j, 0, 'F'));
				}
			}
		}

		ans = -1;

		if(isEdge(first.r, first.c)) {
			ans = 1;
		}else {
			bfs();
		}

		if (ans == -1) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(ans);
		}

	}

	public static void bfs() {

		queue.add(first);
		visit[first.r][first.c] = true;

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			int newr = node.r;
			int newc = node.c;
			int cnt = node.cnt;
			char type = node.type;

			if (type == 'J' && isEdge(newr, newc)) {
				ans = cnt + 1;
				return;
			}

			for (int k = 0; k < 4; k++) {
				int nr = newr + dr[k];
				int nc = newc + dc[k];

				if (nr >= 0 && nc >= 0 && nr < n && nc < m && map[nr][nc] != 'F' && map[nr][nc] != '#') {
					if(type == 'J' && !visit[nr][nc]) {
						visit[nr][nc] = true;
						queue.add(new Node(nr, nc, cnt+1, type));
					}else if(type == 'F'){
						map[nr][nc] = 'F';
						queue.add(new Node(nr, nc, cnt, type));
					}
				}

			}

		}

	}

	public static boolean isEdge(int i, int j) {
		if(i == 0 || j == 0 || i == n-1 || j == m-1) {
			return true;
		}
		return false;
	}

}