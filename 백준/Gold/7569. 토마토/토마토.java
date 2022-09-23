import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dh = {1, -1};
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int n, m, h, day, zeroCnt;
	static int[][][] map;

	static class Node {
		int h, r, c;

		Node(int h, int r, int c) {
			this.h = h;
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		Queue<Node> queue = new LinkedList<>();
		map = new int[h][n][m];
		zeroCnt = 0;
		for(int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					map[k][i][j] = Integer.parseInt(st.nextToken());
					if(map[k][i][j] == 1) {
						queue.add(new Node(k, i, j));
					}
					if (map[k][i][j] == 0) {
						zeroCnt++;
					}
				}
			}
		}
		

		day = 0;
		bfs(queue, 0, zeroCnt);

		System.out.println(day);

	}

	public static void bfs(Queue<Node> que, int t, int zero) {
		if (zero == 0) {
			day = t;
			return;
		}

		Queue<Node> queue = new LinkedList<>();

		int dis = 0;

		while(!que.isEmpty()) {
			Node node = que.poll();

			for (int i = 0; i < 4; i++) {
				int nh = node.h;
				int nr = node.r + dr[i];
				int nc = node.c + dc[i];

				if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
					if (map[nh][nr][nc] == 0) {
						map[nh][nr][nc] = 1;
						dis++;
						queue.add(new Node(nh, nr, nc));
					}
				}
			}

			for(int i = 0; i < 2; i++) {
				int nh = node.h + dh[i];
				int nr = node.r;
				int nc = node.c;

				if(nh >= 0 && nh < h) {
					if (map[nh][nr][nc] == 0) {
						map[nh][nr][nc] = 1;
						dis++;
						queue.add(new Node(nh, nr, nc));
					}
				}
			}
		}

		if(dis == 0) {
			day = -1;
			return;
		}

		bfs(queue, t + 1, zero - dis);
	}

}