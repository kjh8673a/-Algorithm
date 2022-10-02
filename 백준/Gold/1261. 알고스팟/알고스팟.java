import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

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

	static final int INF = Integer.MAX_VALUE;
	static int n, m, ans;
	static int[][] map, dist;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		dist = new int[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				dist[i][j] = INF;
				map[i][j] = str.charAt(j) - '0';
			}
		}

		ans = 0;
		dijkstra();
		System.out.println(ans);

	}

	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.add(new Node(0, 0, 0));
		dist[0][0] = 0;

		while(!pq.isEmpty()) {
			Node point = pq.poll();

			int pr = point.r;
			int pc = point.c;

			if(pr == n-1 && pc == m-1) {
				ans = point.weight;
				return;
			}

			for(int k = 0; k < 4; k++) {
				int nr = pr + dr[k];
				int nc = pc + dc[k];

				if(nr >= 0 && nc >= 0 && nr < n && nc < m) {
					if(dist[nr][nc] > dist[pr][pc] + map[nr][nc]) {
						dist[nr][nc] = dist[pr][pc] + map[nr][nc];
						pq.add(new Node(nr, nc, dist[nr][nc]));
					}
				}
			}
		}

	}

}