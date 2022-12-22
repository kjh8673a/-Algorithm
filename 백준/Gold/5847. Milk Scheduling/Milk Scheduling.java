import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int num;
		int time;

		public Node(int num, int time) {
			this.num = num;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.time, o.time);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 소의 수
		int M = Integer.parseInt(st.nextToken()); // 제약조건의 수

		int ans = 0;

		int[] time = new int[N + 1];
		// 소 한마리당 걸리는 시간
		for (int i = 1; i < N + 1; i++) {
			time[i] = Integer.parseInt(br.readLine());
			if (time[i] > ans) {
				ans = time[i];
			}
		}

		int[] in_degree = new int[N + 1];
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			list.add(new ArrayList<>());
		}
		// 제약조건 a -> b, a를 완료해야 b를 할수있음
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
			in_degree[b]++;
		}

		// in_degree가 0인 번호를 큐에 삽입
		// 시간이 적은것부터 먼저 꺼내게 priorityqueue에 삽입
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 1; i < N + 1; i++) {
			if (in_degree[i] == 0) {
				pq.add(new Node(i, time[i]));
			}
		}

		// 큐가 빌때까지
		while (!pq.isEmpty()) {
			Node now = pq.poll();

			for (int next : list.get(now.num)) {
				in_degree[next]--;
				if (in_degree[next] == 0) {
					time[next] += time[now.num];
					if (time[next] > ans) {
						ans = time[next];
					}
					pq.add(new Node(next, time[next]));
				}
			}
		}

		System.out.println(ans);

	}

}