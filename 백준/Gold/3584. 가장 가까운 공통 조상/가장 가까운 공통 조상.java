import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] list;
	static List<Integer> route;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			list = new ArrayList[N + 1];
			for (int i = 0; i < N + 1; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				list[B].add(A); // 자손 B로 부모 A를 찾을 수 있도록
			}

			st = new StringTokenizer(br.readLine());
			// a와 b의 가장 가까운 공통 조상
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// a로부터 루트 노드까지의 경로를 저장
			route = new ArrayList<>();
			dfs(a);

			// route에 b로부터 루트노드까지 경로 중의 값이 포함되있으면
			// 가장 먼저 등장하는 것이 가장 가까운 공통 조상
			int ans = check(b);

			sb.append(ans).append("\n");
		}

		System.out.println(sb.toString());

	}

	public static void dfs(int a) {
		route.add(a);
		if (list[a].isEmpty()) {
			return;
		} else {
			dfs(list[a].get(0));
		}
	}

	public static int check(int b) {
		if (route.contains(b)) {
			return b;
		} else {
			return check(list[b].get(0));
		}
	}

}