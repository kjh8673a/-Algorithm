import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, start_x, start_y, goal_x, goal_y, ans;
	static int[][] board;
	static int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dc = {2, 1, -1, -2, -2, -1, 1, 2};

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		StringTokenizer st;
		while(t-- > 0) {
			n = Integer.parseInt(br.readLine());

			board = new int[n][n];

			st = new StringTokenizer(br.readLine());
			start_x = Integer.parseInt(st.nextToken());
			start_y = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			goal_x = Integer.parseInt(st.nextToken());
			goal_y = Integer.parseInt(st.nextToken());

			ans = 0;

			bfs(start_x, start_y);

			sb.append(ans).append("\n");

		}

		System.out.println(sb.toString());

	}

	public static void bfs(int i, int j) {
		Queue<Node> queue = new LinkedList<>();

		queue.add(new Node(i, j));
		board[i][j] = 1;

		while(!queue.isEmpty()) {

			Node node = queue.poll();

			int newr = node.r;
			int newc = node.c;

			if(newr == goal_x && newc == goal_y) {
				ans = board[newr][newc] - 1;
			}

			for(int k = 0; k < 8; k++) {
				int nr = newr + dr[k];
				int nc = newc + dc[k];

				if(nr >= 0 && nc >= 0 && nr < n && nc < n && board[nr][nc] == 0) {
					board[nr][nc] = board[newr][newc] + 1;
					queue.add(new Node(nr, nc));
				}
			}

		}
	}
	
}