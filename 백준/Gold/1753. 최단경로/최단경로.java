import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E;
	static List<Edge>[] adjList;
	static long[] dist;
	static boolean[] visit;

	static class Edge implements Comparable<Edge> {
		int v;
		long weight;

		public Edge(int v, long weight) {
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		int start = Integer.parseInt(br.readLine()) - 1;

		adjList = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());

			adjList[u].add(new Edge(v, w));
		}

		dist = new long[V];
		visit = new boolean[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		for (int i = 0; i < V; i++) {
			long ans = dijkstra(start, i);
			if (ans == Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
			} else {
				sb.append(ans).append("\n");
			}

		}

		System.out.println(sb.toString());

	}

	public static long dijkstra(int st, int ed) {
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(st, 0));
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			if (visit[curr.v])
				continue;
			visit[curr.v] = true;

			for (Edge next : adjList[curr.v]) {
				if (!visit[next.v] && dist[next.v] > dist[curr.v] + next.weight) {
					dist[next.v] = dist[curr.v] + next.weight;
					pq.offer(new Edge(next.v, dist[next.v]));
				}
			}
		}

		return dist[ed];
		
	}

}