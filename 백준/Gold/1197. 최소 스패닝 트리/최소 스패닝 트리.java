import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int v, e, pick;
	static int[][] graph;
	static int[] parent;
	static long ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		graph = new int[e][3];

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			graph[i][0] = Integer.parseInt(st.nextToken());
			graph[i][1] = Integer.parseInt(st.nextToken());
			graph[i][2] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(graph, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		parent = new int[v + 1];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}

		ans = 0;
		pick = 0;
		for (int i = 0; i < e; i++) {
			int px = findSet(graph[i][0]);
			int py = findSet(graph[i][1]);

			if (px != py) {
				ans += graph[i][2];
				union(px, py);
				pick++;
			}

			if (pick == (v - 1)) {
				break;
			}
		}

		System.out.println(ans);

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