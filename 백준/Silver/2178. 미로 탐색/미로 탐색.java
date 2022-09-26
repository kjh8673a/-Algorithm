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

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
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

		ans = 0;
		bfs(0,0);

		System.out.println(ans);

	}

	public static void bfs(int i, int j) {
		Queue<Node> queue = new LinkedList<>();

		queue.add(new Node(i, j));
		map[i][j] = 2;

		while(!queue.isEmpty()) {

			Node node = queue.poll();

			int newr = node.r;
			int newc = node.c;

			if(newr == n-1 && newc == m-1) {
				ans = map[newr][newc] - 1;
			}

			for(int k = 0; k < 4; k++) {
				int nr = newr + dr[k];
				int nc = newc + dc[k];

				if(nr >= 0 && nc >= 0 && nr < n && nc < m && map[nr][nc] == 1) {
					map[nr][nc] = map[newr][newc] + 1;
					queue.add(new Node(nr, nc));
				}
			}

		}
	}
	
}