import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
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
	static int n, m, start, end;
	static List<Node>[] adjList;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 정점의 개수
		n = Integer.parseInt(br.readLine());
		// 간선의 개수
		m = Integer.parseInt(br.readLine());

		adjList = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adjList[i] = new ArrayList<>();
		}

		dist = new int[n];
		Arrays.fill(dist, INF);

		StringTokenizer st;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());

			adjList[a].add(new Node(b, w));
		}

		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken()) - 1;
		end = Integer.parseInt(st.nextToken()) - 1;

		dijkstra(start);

		System.out.println(dist[end]);

	}

	public static void dijkstra(int st) {
		PriorityQueue<Node> pq = new PriorityQueue<>();

		boolean[] visit = new boolean[n];
		pq.offer(new Node(st, 0));
		dist[st] = 0;

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
	}

}