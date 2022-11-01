import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int pos, time;

		public Node(int pos, int time) {
			this.pos = pos;
			this.time = time;
		}
	}

	static int N, K, ans1, ans2;
	static int[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		visit = new int[Math.max(N, K) * 2 + 1];
		Arrays.fill(visit, -1);

		ans1 = -1;
		ans2 = 0;

		bfs(N, K);

		System.out.println(ans1);
		System.out.println(ans2);

	}

	public static void bfs(int n, int k) {
		Queue<Node> queue = new LinkedList<>();

		queue.add(new Node(n, 0));
		visit[n] = 0;

		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			int pos = cur.pos;
			int time = cur.time;

			if (pos == k && ans1 == -1) {
				ans1 = time;
				ans2++;
				continue;
			} else if (pos == k && ans1 == time) {
				ans2++;
				continue;
			}

			if (ans1 != -1 && time > ans1) {
				continue;
			}

			if (pos - 1 >= 0 && (visit[pos - 1] == -1 || visit[pos - 1] == time + 1)) {
				visit[pos - 1] = time + 1;
				queue.add(new Node(pos - 1, time + 1));
			}

			if (pos + 1 < visit.length && (visit[pos + 1] == -1 || visit[pos + 1] == time + 1)) {
				visit[pos + 1] = time + 1;
				queue.add(new Node(pos + 1, time + 1));
			}

			if (pos * 2 < visit.length && (visit[pos * 2] == -1 || visit[pos * 2] == time + 1)) {
				visit[pos * 2] = time + 1;
				queue.add(new Node(pos * 2, time + 1));
			}

		}
	}

}