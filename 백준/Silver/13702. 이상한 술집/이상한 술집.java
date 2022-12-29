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

		int[] arr = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		long left = 1;
		long right = max;
		long mid = 0;
		while (left <= right) {
			mid = (left + right) / 2;
			if (mid == 0) {
				break;
			}

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				cnt += arr[i] / mid;
			}

			if (cnt < K) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}

		}

		System.out.println(right);
	}

}