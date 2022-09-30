import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int r;
		int c;
		int age;
		boolean life;

		public Node(int r, int c, int age, boolean life) {
			this.r = r;
			this.c = c;
			this.age = age;
			this.life = life;
		}

		@Override
		public int compareTo(Node n) {
			return Integer.compare(this.age, n.age);
		}
	}

	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int n, m, k, ans;
	static int[][] map, food;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		food = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				food[i][j] = num;
				map[i][j] = 5;
			}
		}


		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());

			pq.add(new Node(x, y, z, true));
		}

		ans = 0;
		solve(0, pq);

		System.out.println(ans);

	}

	public static void solve(int year, PriorityQueue<Node> pq) {
		if (year == k) {
			ans = pq.size();
			return;
		}

		spring(year, pq);

	}

	public static void spring(int year, PriorityQueue<Node> pq) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		Queue<Node> death = new LinkedList<>();
		while (!pq.isEmpty()) {
			Node node = pq.poll();

			int r = node.r;
			int c = node.c;
			int age = node.age;

			if (map[r][c] >= age) {
				map[r][c] -= age;
				queue.add(new Node(r, c, age + 1, true));
			} else {
				death.add(new Node(r, c, age, false));
			}
		}

		summer(year, queue, death);
	}

	public static void summer(int year, PriorityQueue<Node> pq, Queue<Node> death) {

		while (!death.isEmpty()) {
			Node node = death.poll();

			int r = node.r;
			int c = node.c;
			int age = node.age;

			map[r][c] += age / 2;
		}

		fall(year, pq);

	}

	public static void fall(int year, PriorityQueue<Node> pq) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		while (!pq.isEmpty()) {
			Node node = pq.poll();

			int r = node.r;
			int c = node.c;
			int age = node.age;

			queue.add(node);
			if (age % 5 == 0) {

				for (int k = 0; k < 8; k++) {
					int nr = r + dr[k];
					int nc = c + dc[k];

					if (nr >= 0 && nc >= 0 && nr < n && nc < n) {
						queue.add(new Node(nr, nc, 1, true));
					}
				}
			}
		}

		winter(year, queue);

	}

	public static void winter(int year, PriorityQueue<Node> pq) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] += food[i][j];
			}
		}

		solve(year + 1, pq);
	}

}