import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int n, k, finalCnt, size;
	static int[] check;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		size = Math.max(n, k) * 2 + 1;

		check = new int[size];
		Arrays.fill(check, -1);

		bfs(n);

		System.out.println(sb.toString());

	}

	public static void bfs(int num) {
		Queue<Integer> queue = new LinkedList<>();

		queue.add(num);
		check[num] = 0;

		while (!queue.isEmpty()) {
			int point = queue.poll();

			if (point == k) {
				finalCnt = 0;
				Stack<Integer> stack = new Stack<>();
				stack.add(k);
				int now = point;
				while (now != n) {
					stack.add(check[now]);
					now = check[now];
					finalCnt++;
				}
				sb.append(finalCnt).append("\n");
				while(!stack.isEmpty()) {
					sb.append(stack.pop() + " ");
				}
				return;
			}

			if (point - 1 >= 0 && check[point - 1] == -1) {
				int next = point - 1;
				check[next] = point;
				queue.add(next);
			}

			if (point + 1 < size && check[point + 1] == -1) {
				int next = point + 1;
				check[next] = point;
				queue.add(next);
			}

			if (point * 2 < size && check[point * 2] == -1) {
				int next = point * 2;
				check[next] = point;
				queue.add(next);
			}
		}

	}

}