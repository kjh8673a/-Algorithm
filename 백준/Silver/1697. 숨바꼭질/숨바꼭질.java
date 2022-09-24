import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, k, ans;
	static int[] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		ans = 0;
		if (n != k) {
			visit = new int[100001];
			bfs(n);
		}

		System.out.println(ans);

	}

	public static void bfs(int num) {
		Queue<Integer> queue = new LinkedList<>();

		queue.add(num);
		visit[num] = 1;

		while (!queue.isEmpty()) {

			int loc = queue.poll();

			if (loc == k) {
				ans = visit[loc] - 1;
				return;
			}

			if (loc - 1 >= 0 && visit[loc - 1] == 0) {
				visit[loc - 1] = visit[loc] + 1;
				queue.add(loc - 1);
			}

			if (loc + 1 <= 100000 && visit[loc + 1] == 0) {
				visit[loc + 1] = visit[loc] + 1;
				queue.add(loc + 1);
			}

			if (loc * 2 <= 100000 && visit[loc * 2] == 0) {
				visit[loc * 2] = visit[loc] + 1;
				queue.add(loc * 2);
			}
		}
	}

}