import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int mod = 1_000_000_007;
	static List<Integer>[] list;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 노드의 수
		int M = Integer.parseInt(st.nextToken()); // 간선의 수

		list = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}

		long ans = 1;
		visit = new boolean[N + 1];
		for (int i = 1; i < N + 1; i++) {
			if (!visit[i]) {
				ans = (ans * bfs(i)) % mod;
			}
		}

		System.out.println(ans % mod);

	}

	public static long bfs(int num) {
		Queue<Integer> queue = new LinkedList<>();
		visit[num] = true;
		queue.add(num);

		int cnt = 1;
		while (!queue.isEmpty()) {
			int p = queue.poll();

			for (int next : list[p]) {
				if (!visit[next]) {
					queue.add(next);
					visit[next] = true;
					cnt++;
				}
			}
		}

		return cnt;
	}
}