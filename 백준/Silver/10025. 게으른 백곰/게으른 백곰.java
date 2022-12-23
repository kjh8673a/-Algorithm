import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[1000001];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			arr[x] = g;
		}
		int len = 2 * K + 1;
		if (len > 1000000) {
			len = 1000000;
		}

		int sum = 0;
		for (int i = 0; i < len; i++) {
			sum += arr[i];
		}

		int max = sum;
		for (int i = len; i <= 1000000; i++) {
			sum -= arr[i - len];
			sum += arr[i];
			if (sum > max) {
				max = sum;
			}
		}

		System.out.println(max);

	}

}