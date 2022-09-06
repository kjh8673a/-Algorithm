import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int m = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());

			sb.append(binarySearch(num, 0, n - 1)).append("\n");
		}

		System.out.println(sb.toString());

	}

	private static int binarySearch(int num, int low, int high) {
		int mid;

		if (low <= high) {
			mid = (low + high) / 2;

			if (num == arr[mid]) {
				return 1;
			} else if (num < arr[mid]) {
				return binarySearch(num, low, mid - 1);
			} else {
				return binarySearch(num, mid + 1, high);
			}
		}
		return 0;
	}

}