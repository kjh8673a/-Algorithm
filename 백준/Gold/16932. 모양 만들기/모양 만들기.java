import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int n, m, now;
	static int[][] map;

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		Queue<Node> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					queue.add(new Node(i, j));
				}
			}
		}

		int max = 0;
		
		Map<Integer, Integer> group = new HashMap<>();
		int idx = 2;
		while (!queue.isEmpty()) {
			Node node = queue.poll();

			int i = node.r;
			int j = node.c;

			if (map[i][j] == 0) {
				int sum = 1;
				Set<Integer> set = new HashSet<>();
				for (int k = 0; k < 4; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];

					if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
						if (map[nr][nc] == 1) {
							now = 0;
							dfs(nr, nc, idx);
							group.put(idx, now);
							idx++;
						}
						if (map[nr][nc] != 0) {
							set.add(map[nr][nc]);
						}
					}
				}

				Iterator<Integer> iter = set.iterator();
				while (iter.hasNext()) {
					sum += group.get(iter.next());
				}

				max = Math.max(max, sum);
			}
		}

		System.out.println(max);

	}

	public static void dfs(int x, int y, int num) {
		now++;
		map[x][y] = num;

		for (int i = 0; i < 4; i++) {
			int nr = x + dr[i];
			int nc = y + dc[i];

			if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
				if (map[nr][nc] == 1) {
					dfs(nr, nc, num);
				}
			}
		}
	}

}