import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new long[n];

		long max = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, arr[i]);
		}

		System.out.println(binarySearch(m, 1, max));

	}

	private static long binarySearch(int num, long low, long high) {
		long mid;

		if (low <= high) {
			mid = (low + high) / 2;

			long sum = 0;

			for(int i = 0; i < arr.length; i++) {
				if(arr[i] >= mid) {
					sum += arr[i] - mid;
				}
			}

			if(sum < num) {
				return binarySearch(num, low, mid-1);
			}else {
				return binarySearch(num, mid+1, high);
			}
		}
		return high;
	}

}