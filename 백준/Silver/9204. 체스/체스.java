import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] dr = { 1, 1, -1, -1 };
	static int[] dc = { 1, -1, 1, -1 };
	static int[][] board;
	static int ansX, ansY;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int x1 = st.nextToken().charAt(0) - 'A' + 1;
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = st.nextToken().charAt(0) - 'A' + 1;
			int y2 = Integer.parseInt(st.nextToken());

			if ((x1 + y1) % 2 != (x2 + y2) % 2) {
				sb.append("Impossible").append("\n");
				continue;
			}

			if (x1 == x2 && y1 == y2) {
				char ch = (char) (x1 - 1 + 65);
				sb.append(0 + " " + ch + " " + y1).append("\n");
				continue;
			}

			board = new int[9][9];

			ansX = 0;
			ansY = 0;
			color(x1, y1);
			color(x2, y2);

			if (x2 == ansX && y2 == ansY) {
				char ch1 = (char) (x1 - 1 + 65);
				char ch2 = (char) (x2 - 1 + 65);
				sb.append(1 + " " + ch1 + " " + y1);
				sb.append(" " + ch2 + " " + y2).append("\n");
			} else {
				char ch1 = (char) (x1 - 1 + 65);
				char ch2 = (char) (ansX - 1 + 65);
				char ch3 = (char) (x2 - 1 + 65);
				sb.append(2 + " " + ch1 + " " + y1);
				sb.append(" " + ch2 + " " + ansY);
				sb.append(" " + ch3 + " " + y2).append("\n");
			}

		}

		System.out.println(sb.toString());

	}

	public static void color(int r, int c) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(r, c));

		boolean[][] visit = new boolean[9][9];
		visit[r][c] = true;

		int idx = 1;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			board[node.x][node.y]++;

			if (board[node.x][node.y] == 2) {
				ansX = node.x;
				ansY = node.y;
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i] * idx;
				int nc = c + dc[i] * idx;

				if (nr < 1 || nc < 1 || nr > 8 || nc > 8) {
					continue;
				}

				if (visit[nr][nc]) {
					continue;
				}

				queue.add(new Node(nr, nc));
			}
			idx++;
		}

	}

}