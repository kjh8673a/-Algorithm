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
	static int n;
	static int[][] dist;
	static List<Node>[] adjList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken())-1;
		int b = Integer.parseInt(st.nextToken())-1;
		int c = Integer.parseInt(st.nextToken())-1;

		adjList = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			adjList[i] = new ArrayList<>();
		}

		// 0 - A, 1 - B, 2 - C
		dist = new int[3][n];

		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int l = Integer.parseInt(st.nextToken());
			adjList[x].add(new Node(y, l));
			adjList[y].add(new Node(x, l));
		}

		for(int i = 0; i < 3; i++) {
			Arrays.fill(dist[i], INF);
		}
		
		dijkstra(0, a);
		dijkstra(1, b);
		dijkstra(2, c);

		int[] maxDist = new int[n];
		for(int i = 0; i < n; i++) {
			if(i == a || i == b || i == c) {
				continue;
			}
			maxDist[i] = Math.min(Math.min(dist[0][i], dist[1][i]),  dist[2][i]);
		}

		int max = 0;
		int idx = 0;
		for(int i = 0; i < n; i++) {
			if(maxDist[i] > max) {
				max = maxDist[i];
				idx = i;
			}
		}

		System.out.println(idx + 1);

	}

	public static void dijkstra(int type, int st) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		boolean[] visit = new boolean[n];
		pq.offer(new Node(st, 0));
		dist[type][st] = 0;

		while(!pq.isEmpty()) {
			Node curr = pq.poll();

			if(visit[curr.v]) {
				continue;
			}
			visit[curr.v] = true;

			for(Node node : adjList[curr.v]) {
				if(!visit[node.v] && dist[type][node.v] > dist[type][curr.v] + node.weight) {
					dist[type][node.v] = dist[type][curr.v] + node.weight;
					pq.add(new Node(node.v, dist[type][node.v]));
				}
			}
		}

	}

}
