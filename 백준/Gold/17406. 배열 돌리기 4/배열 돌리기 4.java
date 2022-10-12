import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int r, c, s;

		public Node(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}

	static int n, m, k, ans;
	static int[][] map;
	static Node[] list, sel;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		list = new Node[k];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());

			list[i] = new Node(r, c, s);
		}

		sel = new Node[k];
		visited = new boolean[k];

		ans = Integer.MAX_VALUE;
		perm(0);

		System.out.println(ans);

	}

	public static void perm(int idx) {
		if (idx == k) {
			rotate();
		}

		for (int i = 0; i < k; i++) {
			if (visited[i]) {
				continue;
			}
			sel[idx] = list[i];
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;
		}
	}

	public static void rotate() {
		int[][] tmp = new int[n][m];
		for (int i = 0; i < n; i++) {
			System.arraycopy(map[i], 0, tmp[i], 0, m);
		}

		for (int i = 0; i < k; i++) {
			int start_r = sel[i].r - sel[i].s;
			int start_c = sel[i].c - sel[i].s;
			int end_r = sel[i].r + sel[i].s;
			int end_c = sel[i].c + sel[i].s;

			while(start_r < end_r && start_c < end_c) {
				int temp = tmp[start_r][start_c];
				
				// 왼쪽
				for(int j = start_r; j < end_r; j++) {
					tmp[j][start_c] = tmp[j+1][start_c];
				}
				// 아래쪽
				for(int j = start_c; j < end_c; j++) {
					tmp[end_r][j] = tmp[end_r][j+1];
				}
				// 오른쪽
				for(int j = end_r; j > start_r; j--) {
					tmp[j][end_c] = tmp[j-1][end_c];
				}
				// 위쪽
				for(int j = end_c; j > start_c; j--) {
					if(j == start_c + 1) {
						tmp[start_r][j] = temp;
					}else {
						tmp[start_r][j] = tmp[start_r][j-1];
					}
				}

				start_r++;
				start_c++;
				end_r--;
				end_c--;
			}
		}
		
		cal(tmp);
	}

	public static void cal(int[][] arr) {
		int score = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int now = 0;
			for (int j = 0; j < m; j++) {
				now += arr[i][j];
			}
			score = Math.min(score, now);
		}

		ans = Math.min(ans, score);
	}

}