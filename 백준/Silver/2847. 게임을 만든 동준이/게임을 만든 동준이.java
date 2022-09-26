import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			stack.add(num);
		}

		int ans = 0;
		while (stack.size() != 1) {
			int back = stack.pop();

			if (stack.peek() < back) {
				continue;
			} else {
				int front = stack.pop();
				ans += front - back + 1;
				stack.add(back - 1);
			}

		}

		System.out.println(ans);

	}

}