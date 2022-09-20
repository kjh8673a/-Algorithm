import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] arr;
	static int sum, one, two;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		arr = new int[9];
		sum = 0;
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		Arrays.sort(arr);

		one = 0;
		two = 0;
		pickTwo(-1, -1);

		for (int i = 0; i < 9; i++) {
			if (i != one && i != two) {
				sb.append(arr[i]).append("\n");
			}
		}

		System.out.println(sb.toString());

	}

	public static void pickTwo(int a, int b) {
		if (a != -1 && b != -1) {
			if (sum - arr[a] - arr[b] == 100) {
				one = a;
				two = b;
			}
			return;
		}
		for (int i = a + 1; i < 9; i++) {
			if (a == -1) {
				pickTwo(i, b);
			} else {
				pickTwo(a, i);
			}
		}
	}

}