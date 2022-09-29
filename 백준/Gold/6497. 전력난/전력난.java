import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static int V, E;
	static long ans;
	static int[][] graph;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken()); // 정점의 개수
			E = Integer.parseInt(st.nextToken()); // 간선의 개수

			if(V == 0 && E == 0) {
				break;
			}
	
			graph = new int[E][3];
	
			long total = 0;
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()); // 시작 정점
				int b = Integer.parseInt(st.nextToken()); // 도착 정점
				int c = Integer.parseInt(st.nextToken()); // 가중치
	
				graph[i][0] = a;
				graph[i][1] = b;
				graph[i][2] = c;
	
				total += c;
			}

			Arrays.sort(graph, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[2] - o2[2];
				}
			});

			parent = new int[V];
			for(int i = 0; i < parent.length; i++) {
				parent[i] = i;
			}

			// 크루스칼 알고리즘
			ans = 0;
			int pick = 0;
			for(int i = 0; i < E; i++) {
				int px = findSet(graph[i][0]);
				int py = findSet(graph[i][1]);

				if(px != py) {
					ans += graph[i][2];
					union(px, py);
					pick++;
				}

				if(pick == V-1) {
					break;
				}
			}
			
			sb.append(total - ans).append("\n");

		}

		System.out.println(sb.toString());
		
	}

	public static int findSet(int x) {
        if(x == parent[x]) {
            return x;
        }else {
            parent[x] = findSet(parent[x]);

            return parent[x];
        }
    }

    public static void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);

        if(px > py) {
            parent[py] = px;
        }else {
            parent[px] = py;
        }
    }

}