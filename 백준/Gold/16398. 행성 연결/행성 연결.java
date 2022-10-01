import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	// 프림 알고리즘

	public static class Node implements Comparable<Node> {
		int v, w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node node) {
			return Integer.compare(this.w, node.w);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 정점의 수
		int n = Integer.parseInt(br.readLine());

		ArrayList<Node>[] list = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}

		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				int weight = Integer.parseInt(st.nextToken());
				// 간선을 저장한다
				if(weight != 0) {
					list[i].add(new Node(j, weight));
				}
			}
		}

		boolean[] visit = new boolean[n];

		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.add(new Node(0, 0));

		int cnt = 0;
		long ans = 0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();

			// 이미 방문했다면 continue
			if(visit[node.v]) {
				continue;
			}

			// 방문안했다면 방문처리, 거리 증가
			visit[node.v] = true;
			ans += node.w;

			// 해당 포인트에 연결된 노드를 체크하여 방문하지 않았다면 pq에 넣는다
			for(Node next : list[node.v]) {
				if(!visit[next.v]) {
					pq.add(next);
				}
			}

			// 모든 정점을 돌았다면 break
			if(++cnt == n) {
				break;
			}
		}

		System.out.println(ans);

	}

}