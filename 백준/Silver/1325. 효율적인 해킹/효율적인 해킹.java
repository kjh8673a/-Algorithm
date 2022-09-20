import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] list;
	static int[] cnt;
	static int n, m;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		list = new ArrayList[n+1];

		for(int i = 0; i < n; i++) {
			list[i] = new ArrayList<>();
		}

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a-1].add(b-1);
		}

		cnt = new int[n];

		for(int i = 0; i < n; i++) {
			visit = new boolean[n];
			dfs(i);
		}

		int max = 0;
		for(int i = 0; i < n; i++) {
			if(cnt[i] > max) {
				max = cnt[i];
			}
		}

		for(int i = 0; i < n; i++) {
			if(cnt[i] == max) {
				sb.append((i+1) + " ");
			}
		}

		System.out.println(sb.toString());

	}

	public static void dfs(int idx) {
		visit[idx] = true;

		for(int i : list[idx]) {
			if(!visit[i]) {
				cnt[i]++;
				dfs(i);
			}
		}
	}

}