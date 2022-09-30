import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int n, m, v, ans, pick;
	static int[] parent;
	static int[][] map, graph, link;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				int num = Integer.parseInt(st.nextToken());
				if(num == 1) {
					map[i][j] = -1;
				}else {
					map[i][j] = num;
				}
				
			}
		}

		// 섬의개수 & 마킹
		v = 0; 
		int idx = 1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(map[i][j] == -1) {
					marking(i, j, idx);
					v++;
					idx++;
				}
				
			}
		}

		graph = new int[v][v];
		// 다리 연결
		makeBridge();
		
		// 다리 그래프에 옮기기
		makeGraph();

		Arrays.sort(link, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		parent = new int[v];
		for(int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}

		ans = 0;
		pick = 0;
		for(int i = 0; i < link.length; i++) {
			int px = findSet(link[i][0]);
			int py = findSet(link[i][1]);

			if(px != py) {
				ans += link[i][2];
				union(px, py);
				pick++;
			}

			if(pick == (v-1)) {
				break;
			}
		}

		if(pick < v-1) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}
        
	}

	public static void marking(int x, int y, int num) {
		map[x][y] = num;

		for(int i = 0; i < 4; i++) {
			int nr = x + dr[i];
			int nc = y + dc[i];

			if(nr >= 0 && nc >= 0 && nr < n && nc < m) {
				if(map[nr][nc] == -1) {
					marking(nr, nc, num);
				}
			}
		}
	}

	public static void makeBridge() {
		// 가로 다리
		for(int i = 0; i < n; i++) {
			int start = 0;
			int sx = 0;
			int end = 0;
			int ex = 0;
			for(int j = 0; j < m; j++) {
				if(map[i][j] == 0) {
					if(j > 0 && map[i][j-1] != 0) {
						start = map[i][j-1];
						sx = j-1;
					}
				}
				if(start != 0 && map[i][j] != 0) {
					end = map[i][j];
					ex = j;
					int len = ex - sx - 1;
					if(len >= 2) {
						if(graph[start-1][end-1] != 0) {
							graph[start-1][end-1] = Math.min(len, graph[start-1][end-1]);
							graph[end-1][start-1] = Math.min(len, graph[end-1][start-1]);
						}else {
							graph[start-1][end-1] = len;
							graph[end-1][start-1] = len;
						}
					}
					start = 0;
					sx = 0;
					end = 0;
					ex = 0;
				}
			}
		}

		// 세로 다리
		for(int i = 0; i < m; i++) {
			int start = 0;
			int sx = 0;
			int end = 0;
			int ex = 0;
			for(int j = 0; j < n; j++) {
				if(map[j][i] == 0) {
					if(j > 0 && map[j-1][i] != 0) {
						start = map[j-1][i];
						sx = j-1;
					}
				}
				if(start != 0 && map[j][i] != 0) {
					end = map[j][i];
					ex = j;
					int len = ex - sx - 1;
					if(len >= 2) {
						if(graph[start-1][end-1] != 0) {
							graph[start-1][end-1] = Math.min(len, graph[start-1][end-1]);
							graph[end-1][start-1] = Math.min(len, graph[end-1][start-1]);
						}else {
							graph[start-1][end-1] = len;
							graph[end-1][start-1] = len;
						}
					}
					start = 0;
					sx = 0;
					end = 0;
					ex = 0;
				}
			}
		}
	}

	public static void makeGraph() {
		int e = 0;
		for(int i = 0; i < graph.length; i++) {
			for(int j = i; j < graph.length; j++) {
				if(graph[i][j] != 0) {
					e++;
				}
			}
		}

		link = new int[e][3];

		int idx = 0;
		for(int i = 0; i < graph.length; i++) {
			for(int j = i; j < graph.length; j++) {
				if(graph[i][j] != 0) {
					link[idx][0] = i;
					link[idx][1] = j;
					link[idx][2] = graph[i][j];
					idx++;
				}
			}
		}
	}

	public static int findSet(int x) {
		if (x == parent[x]) {
			return x;
		} else {
			return findSet(parent[x]);
		}
	}

	public static void union(int x, int y) {
		if (x > y) {
			parent[y] = x;
		} else {
			parent[x] = y;
		}
	}

}