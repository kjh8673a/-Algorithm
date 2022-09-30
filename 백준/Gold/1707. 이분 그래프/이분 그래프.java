import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 이분그래프 - 인접한 정점끼리 서로 다른 색으로 칠하여 모든 정점을
	 * 두 그룹으로 나누고, 서로 다른 그룹의 정점을 간선으로 연결한 그래프
	 * 
	 * 모든 인접한 정점이 서로 다른 색으로 칠해지면 이분그래프
	 */

	static int V, E;
	static ArrayList<Integer>[] list;
	static int[] color;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int K = Integer.parseInt(br.readLine());

		StringTokenizer st;
		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			list = new ArrayList[V];
			for (int i = 0; i < V; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken()) - 1;
				int v = Integer.parseInt(st.nextToken()) - 1;

				list[u].add(v);
				list[v].add(u);
			}

			boolean isOk = true;
			color = new int[V];
			for (int i = 0; i < V; i++) {
				if (color[i] == 0) {
					if (!bfs(i)) {
						isOk = false;
					}

				}
			}

			if (isOk) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}

		}

		System.out.println(sb.toString());

	}

	public static boolean bfs(int idx) {
		Queue<Integer> queue = new LinkedList<>();

		queue.add(idx);
		color[idx] = 1;

		while (!queue.isEmpty()) {
			int point = queue.poll();

			for (int n : list[point]) {
				if (color[point] == color[n]) {
					return false;
				}
				if (color[n] == 0) {
					color[n] = (color[point] == 1) ? 2 : 1;
					queue.add(n);
				}
			}
		}

		return true;

	}

}