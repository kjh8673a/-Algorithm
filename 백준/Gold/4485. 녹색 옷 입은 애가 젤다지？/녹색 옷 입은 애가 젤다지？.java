import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 다익스트라
	 */

	static class Node implements Comparable<Node> {
		int r, c, weight;

		public Node(int r, int c, int weight) {
			this.r = r;
			this.c = c;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node node) {
			return Integer.compare(this.weight, node.weight);
		}
	}

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static final int INF = Integer.MAX_VALUE;
	static int n, ans;
	static int[][] map, dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		int tc = 0;
		while (true) {
			tc++;
			n = Integer.parseInt(br.readLine());
			if (n == 0) {
				break;
			}

			map = new int[n][n];
			dist = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = INF;
				}
			}

			ans = 0;
			dijkstra();

			sb.append("Problem " + tc + ": " + ans).append("\n");
		}

		System.out.println(sb.toString());

	}

	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		boolean[][] visit = new boolean[n][n];

		pq.add(new Node(0, 0, map[0][0]));
		dist[0][0] = map[0][0];

		while (!pq.isEmpty()) {
			Node point = pq.poll();

			int pr = point.r;
			int pc = point.c;

			if (pr == n - 1 && pc == n - 1) {
				ans = point.weight + map[pr][pc];
				return;
			}

			if (visit[pr][pc]) {
				continue;
			}

			visit[pr][pc] = true;

			for (int k = 0; k < 4; k++) {
				int nr = pr + dr[k];
				int nc = pc + dc[k];

				if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
					if (!visit[nr][nc] && dist[nr][nc] > dist[pr][pc] + map[nr][nc]) {
						dist[nr][nc] = dist[pr][pc] + map[nr][nc];
						pq.add(new Node(nr, nc, dist[pr][pc]));
					}
				}
			}
		}
	}

}