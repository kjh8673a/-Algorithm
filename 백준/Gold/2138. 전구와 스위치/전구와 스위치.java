import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		int[] sample1 = new int[n];
		int[] sample2 = new int[n];
		String str = br.readLine();
		for (int i = 0; i < n; i++) {
			int num = str.charAt(i) - '0';
			sample1[i] = sample2[i] = num;
		}

		int[] result = new int[n];
		str = br.readLine();
		for (int i = 0; i < n; i++) {
			result[i] = str.charAt(i) - '0';
		}

		ans = -1;

		changeOne(sample1, result);

		unchangeOne(sample2, result);

		System.out.println(ans);

	}

	public static void changeOne(int[] arr, int[] result) {
		toggle(0, arr);
		toggle(1, arr);

		int cnt = 0;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] != result[i]) {
				toggle(i, arr);
				toggle(i + 1, arr);
				if (i != n - 2) {
					toggle(i + 2, arr);
				}
				cnt++;
			}
		}

		boolean flag = true;
		for (int i = 0; i < n; i++) {
			if (arr[i] != result[i]) {
				flag = false;
				break;
			}
		}

		if (flag) {
			ans = cnt + 1;
		}

	}

	public static void unchangeOne(int[] arr, int[] result) {
		int cnt = 0;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] != result[i]) {
				toggle(i, arr);
				toggle(i + 1, arr);
				if (i != n - 2) {
					toggle(i + 2, arr);
				}
				cnt++;
			}
		}

		boolean flag = true;
		for (int i = 0; i < n; i++) {
			if (arr[i] != result[i]) {
				flag = false;
				break;
			}
		}

		if (flag) {
			ans = cnt;
		}

	}

	public static void toggle(int idx, int[] arr) {
		if (arr[idx] == 1) {
			arr[idx] = 0;
		} else if (arr[idx] == 0) {
			arr[idx] = 1;
		}
		
	}

}