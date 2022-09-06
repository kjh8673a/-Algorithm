import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		arr = new long[k];

		long max = 0;
		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}

		System.out.println(binarySearch(n, 1, max));

	}

	private static long binarySearch(int num, long low, long high) {
		long mid;

		if (low <= high) {
			mid = (low + high) / 2;

			long cnt = 0;

			for(int i = 0; i < arr.length; i++) {
				cnt += arr[i] / mid;
			}

			if(cnt < num) {
				return binarySearch(num, low, mid-1);
			}else {
				return binarySearch(num, mid+1, high);
			}
		}
		return high;
	}

}