import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, ans;
	static int[] member;
	static boolean[] made, visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			member = new int[n + 1];

			for (int i = 1; i < n + 1; i++) {
				member[i] = Integer.parseInt(st.nextToken());
			}

			made = new boolean[n + 1];
			visit = new boolean[n + 1];
			ans = 0;
			for (int i = 1; i < n + 1; i++) {
				if (!made[i]) {
					dfs(i);
				}
			}

			sb.append(n - ans).append("\n");

		}

		System.out.println(sb.toString());

	}

	public static void dfs(int start) {
		if(visit[start]) {
			made[start] = true;
			ans++;
		}

		visit[start] = true;

		if (!made[member[start]]) {
			dfs(member[start]);
		}
		
		visit[start] = false;
		made[start] = true;
	}

}