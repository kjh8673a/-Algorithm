import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int k, w, h, ans;
	static int[][] map;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};

	static int[] hr = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] hc = {2, 1, -1, -2, -2, -1, 1, 2};

	static boolean[][][] visit;

	static class Node {
		int r, c, cnt, horse;

		Node(int r, int c, int cnt, int horse) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.horse = horse;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		map = new int[h][w];

		for(int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visit = new boolean[h][w][k+1];
		ans = -1;
		bfs(0, 0);

		System.out.println(ans);

	}

	public static void bfs(int i, int j) {
		Queue<Node> queue = new LinkedList<>();

		queue.add(new Node(i, j, 0, 0));

		visit[i][j][0] = true;

		while(!queue.isEmpty()) {
			Node node = queue.poll();

			int newr = node.r;
			int newc = node.c;

			if(newr == h-1 && newc == w-1) {
				ans = node.cnt;
				return;
			}

			for(int l = 0; l < 4; l++) {
				int nr = newr + dr[l];
				int nc = newc + dc[l];
				if(nr >= 0 && nc >= 0 && nr < h && nc < w) {
					if(!visit[nr][nc][node.horse] && map[nr][nc] != 1) {
						visit[nr][nc][node.horse] = true;
						
						queue.add(new Node(nr, nc, node.cnt + 1, node.horse));
					}
				}
			}
			
			if(node.horse < k) {
				for(int l = 0; l < 8; l++) {
					int nr = newr + hr[l];
					int nc = newc + hc[l];
	
					if(nr >= 0 && nc >= 0 && nr < h && nc < w) {
						if(!visit[nr][nc][node.horse + 1] && map[nr][nc] != 1) {
							visit[nr][nc][node.horse + 1] = true;
							queue.add(new Node(nr, nc, node.cnt + 1, node.horse + 1));
						}
					}
	
				}
			}
			
		}
	}
}