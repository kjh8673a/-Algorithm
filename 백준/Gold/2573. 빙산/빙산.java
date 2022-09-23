import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, cnt;
	static int[][] map;
	static boolean[][] map2;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};

	static class Node {
		int r, c, n;

		Node(int r, int c, int n) {
			this.r = r;
			this.c = c;
			this.n = n;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int year = 0;
		while(true) {
			if(year > 0) {
				melt();
			}

			int count = 0;
			map2 = new boolean[n][m];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(map[i][j] > 0) {
						map2[i][j] = true;
						count++;
					}
				}
			}
			
			if(count == 0) {
				System.out.println(0);
				break;
			}

			cnt = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(map2[i][j]) {
						dfs(i, j);
						cnt++;
					}
				}
			}

			if(cnt >= 2) {
				System.out.println(year);
				break;
			}

			year++;
		}
		
	}

	public static void dfs(int x, int y) {
		map2[x][y] = false;

		for(int i = 0; i < 4; i++) {
			int nr = x + dr[i];
			int nc = y + dc[i];

			if(nr >= 0 && nc >= 0 && nr < n && nc < m) {
				if(map2[nr][nc]) {
					dfs(nr, nc);
				}
			}
		}
	}

	public static void melt() {
		Queue<Node> queue = new LinkedList<>();

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] > 0) {
					int mcnt = 0;

					for(int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];

						if(nr >= 0 && nc >= 0 && nr < n && nc < m) {
							if(map[nr][nc] == 0) {
								mcnt++;
							}
						}
					}

					queue.add(new Node(i, j, mcnt));

				}
			}
		}

		while(!queue.isEmpty()) {
			Node node = queue.poll();

			map[node.r][node.c] -= node.n;

			if(map[node.r][node.c] < 0) {
				map[node.r][node.c] = 0;
			}
		}
	}

	
}