import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visit;
	static int[][] connect;
	static int n, m;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		connect = new int[n+1][n+1];
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			connect[u][v] = 1;
			connect[v][u] = 1;
		}

		visit = new boolean[n+1];
		int cnt = 0;

		for(int i = 1; i < n+1; i++) {
			if(!visit[i]) {
				dfs(i);
				cnt++;
			}
		}

		System.out.println(cnt);

    }

	public static void dfs(int num) {
		visit[num] = true;

		for(int i = 1; i < n+1; i++) {
			if(connect[num][i] == 1 && !visit[i]) {
				dfs(i);
			}
		}

	}

}