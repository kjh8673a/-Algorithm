import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n, m, v;
	static boolean[] visit;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());

		arr = new int[n+1][n+1];
		visit = new boolean[n+1];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;
		}

		dfs(v);
		sb.append("\n");

		Arrays.fill(visit, false);
		bfs(v);

		System.out.println(sb.toString());
		
	}

	public static void dfs(int num) {
		visit[num] = true;
		sb.append(num + " ");
		for(int i = 1; i < n+1; i++) {
			if(arr[num][i] == 1 && !visit[i]) {
				dfs(i);
			}
		}
	}

	public static void bfs(int num) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(num);
		visit[num] = true;
		sb.append(num + " ");

		while(!queue.isEmpty()) {
			int tmp = queue.poll();

			for(int i = 1; i < n+1; i++) {
				if(arr[tmp][i] == 1 && !visit[i]) {
					visit[i] = true;
					sb.append(i + " ");
					queue.add(i);
				}
			}
		}

	}

}