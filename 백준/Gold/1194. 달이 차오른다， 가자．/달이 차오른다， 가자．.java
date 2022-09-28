import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, h, w, sr, sc, ans;
	static char[][] map;
	static boolean[][][] visit;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static class Node {
		int r, c, cnt, key;

		Node(int r, int c, int cnt, int key) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.key = key;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		visit = new boolean[n][m][64];
		sr = 0;
		sc = 0;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);

				if (map[i][j] == '0') {
					sr = i;
					sc = j;
				}
			}
		}

		ans = Integer.MAX_VALUE;
		bfs(sr, sc);

		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}

	}

	public static void bfs(int i, int j) {

		Queue<Node> queue = new LinkedList<>();

		queue.add(new Node(i, j, 0, 0));
		visit[i][j][0] = true;

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			int newr = node.r;
			int newc = node.c;
			int cnt = node.cnt;
			int key = node.key;

			if (map[newr][newc] == '1') {
				ans = cnt;
				return;
			}

			for (int k = 0; k < 4; k++) {
				int nr = newr + dr[k];
				int nc = newc + dc[k];

				if (nr >= 0 && nc >= 0 && nr < n && nc < m && !visit[nr][nc][key] && map[nr][nc] != '#') {
					if (map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
						// a를 만나면 0번째자리를 1로 바꾸고, b를 만나면 1번째자리를 1로 바꾼다...
						int newkey = (1 << (map[nr][nc] - 'a')) | key;
						// newkey와 key가 같다면 이미 방문처리 되있으면 방문 안해도 된다
						if (!visit[nr][nc][newkey]) {
							visit[nr][nc][newkey] = true;
							queue.add(new Node(nr, nc, cnt + 1, newkey));
						}
					} else if (map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {
						int door = (1 << (map[nr][nc] - 'A'));
						// 문에 해당하는 알파벳을 비트로 나타내서 key와 비교
						if ((door & key) > 0) {
							visit[nr][nc][key] = true;
							queue.add(new Node(nr, nc, cnt + 1, key));
						}
					} else {
						visit[nr][nc][key] = true;
						queue.add(new Node(nr, nc, cnt + 1, key));
					}
				}

			}

		}

	}

}