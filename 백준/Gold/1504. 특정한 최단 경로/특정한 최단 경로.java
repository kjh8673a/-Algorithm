import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int v, weight;

		public Node(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static final int INF = Integer.MAX_VALUE;
	static int N, E;
	static List<Node>[] adjList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adjList[u].add(new Node(v, w));
			adjList[v].add(new Node(u, w));
		}

		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int StarttoA = dijkstra(1, a);
		int AtoB = dijkstra(a, b);
		int BtoEnd = dijkstra(b, N);

		int StarttoB = dijkstra(1, b);
		int BtoA = dijkstra(b, a);
		int AtoEnd = dijkstra(a, N);

		boolean checkA = false;
		if (StarttoA == INF || AtoB == INF || BtoEnd == INF) {
			checkA = true;
		}
		boolean checkB = false;
		if (StarttoB == INF || BtoA == INF || AtoEnd == INF) {
			checkB = true;
		}

		int ans = 0;
		if (!checkA && !checkB) {
			ans = Math.min(StarttoA + AtoB + BtoEnd, StarttoB + BtoA + AtoEnd);
		} else if (!checkA && checkB) {
			ans = StarttoA + AtoB + BtoEnd;
		} else if (checkA && !checkB) {
			ans = StarttoB + BtoA + AtoEnd;
		} else {
			ans = -1;
		}

		System.out.println(ans);

	}

	public static int dijkstra(int st, int ed) {
		int[] dist = new int[N + 1];
		boolean[] visit = new boolean[N + 1];
		Arrays.fill(dist, INF);
		dist[st] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(st, 0));

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			if (visit[curr.v]) {
				continue;
			}

			visit[curr.v] = true;

			for (Node node : adjList[curr.v]) {
				if (!visit[node.v] && dist[node.v] > dist[curr.v] + node.weight) {
					dist[node.v] = dist[curr.v] + node.weight;
					pq.add(new Node(node.v, dist[node.v]));
				}
			}
		}

		return dist[ed];
	}

}