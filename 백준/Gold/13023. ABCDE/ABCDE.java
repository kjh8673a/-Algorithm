import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	/*
	 * A - B - C - D - E 다섯명이 이어져 있는지 ?
	 */
	static int n, m, ans;
	static boolean[] check;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		list = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// a와 b는 친구
			list[a].add(b);
			list[b].add(a);
		}

		check = new boolean[n];

		ans = 0;
		for (int i = 0; i < n; i++) {
			// 아직 5명 연결을 못찾았을 때만 탐색
			if (ans == 0) {
				// i번 방문처리하고 i번부터 탐색 시작
				check[i] = true;
				dfs(i, 0);
				check[i] = false;
			}
		}

		System.out.println(ans);
	}

	public static void dfs(int idx, int cnt) {
		// cnt가 4라면 5명이 연결된 것
		if (cnt == 4) {
			ans = 1;
			return;
		}

		for (int i = 0; i < list[idx].size(); i++) {
			if (!check[list[idx].get(i)]) {
				// idx번 사람과 연결된 사람 방문처리하고 그 사람으로 가서 탐색
				check[list[idx].get(i)] = true;
				dfs(list[idx].get(i), cnt + 1);
				check[list[idx].get(i)] = false;
			}
		}
	}
}