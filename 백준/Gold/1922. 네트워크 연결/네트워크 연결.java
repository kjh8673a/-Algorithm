import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge> {
		int v;
		int weight;

		public Edge(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o){
			return Integer.compare(this.weight, o.weight);
		}
	}

	static int V, E;
	static List<Edge>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		V = Integer.parseInt(br.readLine()); // 정점의 개수
		E = Integer.parseInt(br.readLine()); // 간선의 개수

		graph = new ArrayList[V];
		for(int i = 0; i < V; i++) {
			graph[i] = new ArrayList<>();
		}

		StringTokenizer st;
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1; // 시작 정점
			int b = Integer.parseInt(st.nextToken())-1; // 도착 정점
			int c = Integer.parseInt(st.nextToken()); // 가중치

			graph[a].add(new Edge(b, c));
			graph[b].add(new Edge(a, c));
		}

		boolean[] visit = new boolean[V]; // 방문처리

		PriorityQueue<Edge> pq = new PriorityQueue<>();

		visit[0] = true;

		pq.addAll(graph[0]);

		long ans = 0;
		int cnt = 1; // 획득한 정점의 개수
		while(cnt != V) {
			Edge edge = pq.poll(); // 연결된 간선 하나 뽑아서

			if(visit[edge.v]) continue; // 이미 뽑은 정점이라면 넘어간다

			ans += edge.weight;
			pq.addAll(graph[edge.v]);
			visit[edge.v] = true;
			cnt++;
		}

		System.out.println(ans);
		
	}

}