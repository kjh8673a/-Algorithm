import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	static Stack<Integer> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Queue<Integer> queue = new LinkedList<>();
		String input = "";
		while ((input = br.readLine()) != null && !input.isEmpty()) {
			int num = Integer.parseInt(input);
			queue.add(num);
		}

		stack = new Stack<>();
		solve(queue.poll(), queue);

		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append("\n");
		}

		System.out.println(sb);

	}

	public static void solve(int root, Queue<Integer> q) {
		stack.add(root);

		Queue<Integer> left = new LinkedList<>();
		Queue<Integer> right = new LinkedList<>();

		boolean isLeft = true;
		while (!q.isEmpty()) {
			int num = q.poll();
			if (isLeft && num > root) {
				isLeft = false;
			}
			if (isLeft) {
				left.add(num);
			} else {
				right.add(num);
			}
		}

		if (!right.isEmpty()) {
			solve(right.poll(), right);
		}

		if (!left.isEmpty()) {
			solve(left.poll(), left);
		}

	}

}