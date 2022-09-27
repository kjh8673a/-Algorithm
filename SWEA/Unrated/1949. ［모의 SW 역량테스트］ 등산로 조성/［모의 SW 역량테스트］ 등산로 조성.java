import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int n, k, result;
	static int[][] map;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static boolean[][] visit;

	static class Peek {
		int r, c;

		Peek(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static class Node {
		int r, c, cnt, height, dig;
		boolean[][] myvisit;

		Node(int r, int c, int cnt, int height, int dig, boolean[][] myvisit) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.height = height;
			this.dig = dig;

			this.myvisit = myvisit;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			int max = 0;
			map = new int[n][n];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}

			Queue<Peek> peeks = new LinkedList<>();
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j] == max) {
						peeks.add(new Peek(i, j));
					}
				}
			}

			int ans = 0;

			while(!peeks.isEmpty()) {
				Peek p = peeks.poll();

				int rr = p.r;
				int cc = p.c;

				visit = new boolean[n][n];
				result = 0;
				bfs(rr, cc);
				ans = Math.max(result, ans);
			}

			sb.append("#" + tc + " " + ans).append("\n");
		}

		System.out.println(sb.toString());

	}

	public static void bfs(int i, int j) {
		Queue<Node> queue = new LinkedList<>();

		queue.add(new Node(i, j, 1, map[i][j], 0, visit));

		while(!queue.isEmpty()) {
			Node node = queue.poll();

			int newr = node.r;
			int newc = node.c;

			boolean[][] rvisit = new boolean[n][n];
			rvisit = copy(node.myvisit);
			rvisit[newr][newc] = true;

			result = Math.max(node.cnt, result);

			for(int d = 0; d < 4; d++) {
				int nr = newr + dr[d];
				int nc = newc + dc[d];

				if(nr >= 0 && nc >= 0 && nr < n && nc < n && !node.myvisit[nr][nc]) {
					if(node.dig == 0) {
						if(map[nr][nc] < node.height) {
							queue.add(new Node(nr, nc, node.cnt + 1, map[nr][nc], 0, rvisit));
						}else {
							if(map[nr][nc] - node.height < k) {
								queue.add(new Node(nr, nc, node.cnt + 1, node.height-1, 1, rvisit));
							}
						}
					}else if(node.dig == 1) {
						if(map[nr][nc] < node.height) {
							queue.add(new Node(nr, nc, node.cnt + 1, map[nr][nc], 1, rvisit));
						}
					}

				}
			}
		}

	}

	public static boolean[][] copy(boolean[][] b) {

		boolean[][] newvisit = new boolean[n][n];

		for(int i = 0; i < n; i++) {
			System.arraycopy(b[i], 0, newvisit[i], 0, newvisit[i].length);
		}

		return newvisit;

	}
	
}