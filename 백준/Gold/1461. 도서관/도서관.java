import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];

		int mCnt = 0;
		int pCnt = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] > 0) {
				pCnt++;
			} else {
				mCnt++;
			}
		}

		Arrays.sort(arr);

		int sum = 0;

		int idx = 0;
		int tmp = 0;
		while (true) {
			if (mCnt == 0) {
				sum += Math.abs(tmp) * 2;
				break;
			}
			if ((idx + 1) % m == 1 || m == 1) {
				tmp = arr[idx];
			}
			if ((idx + 1) % m == 0) {
				sum += Math.abs(tmp) * 2;
				tmp = 0;
			}
			mCnt--;
			idx++;
		}

		idx = n - 1;
		tmp = 0;
		while (true) {
			if (pCnt == 0) {
				sum += Math.abs(tmp) * 2;
				break;
			}
			if ((n - idx) % m == 1 || m == 1) {
				tmp = arr[idx];
			}
			
			if ((n - idx) % m == 0) {
				sum += Math.abs(tmp) * 2;
				tmp = 0;
			}
			pCnt--;
			idx--;
		}

		if (Math.abs(arr[0]) < Math.abs(arr[n - 1])) {
			sum -= Math.abs(arr[n-1]);
		} else {
			sum -= Math.abs(arr[0]);

		}

		System.out.println(sum);

	}

}