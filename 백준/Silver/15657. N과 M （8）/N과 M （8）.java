import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] numbers, result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		numbers = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);

		result = new int[m];
		find(0);

		System.out.println(sb);

	}

	public static void find(int cnt) {
		if (cnt > m) {
			return;
		}

		if (cnt == m) {
			if (check(result)) {
				for (int i = 0; i < m; i++) {
					sb.append(result[i] + " ");
				}
				sb.append("\n");
			}
			return;
		}

		for (int i = 0; i < n; i++) {
			result[cnt] = numbers[i];
			find(cnt + 1);
		}
	}

	public static boolean check(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] > arr[i]) {
				return false;
			}
		}
		return true;
	}

}