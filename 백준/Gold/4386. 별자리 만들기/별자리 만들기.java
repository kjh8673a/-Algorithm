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
		double weight;

		public Edge(int v, double weight) {
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o){
			return Double.compare(this.weight, o.weight);
		}
	}

	static List<Edge>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		double[][] star = new double[n][2]; 
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			star[i][0] = Double.parseDouble(st.nextToken());
			star[i][1] = Double.parseDouble(st.nextToken());
		}

		int k = cntEdge(n);

		graph = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}

		int idx = 0;
		while(idx != 2 * k) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(i != j) {
						double weight = calWeight(star[i][0], star[i][1], star[j][0], star[j][1]);
						graph[i].add(new Edge(j, weight));
						idx++;
					}
				}
			}
		}

		boolean[] visit = new boolean[n];

		PriorityQueue<Edge> pq = new PriorityQueue<>();

		visit[0] = true;

		pq.addAll(graph[0]);

		double ans = 0;
		int cnt = 1;
		while(cnt != n) {
			Edge edge = pq.poll();

			if(visit[edge.v]) continue;

			ans += edge.weight;
			pq.addAll(graph[edge.v]);
			visit[edge.v] = true;
			cnt++;
		}

		System.out.println(String.format("%.2f", ans));
		
	}

	public static double calWeight(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
 
    public static int cntEdge(int n) {
        return n + n * (n - 3) / 2;
    }

}