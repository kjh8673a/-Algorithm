import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 운동기구의 개수 n
		int n = Integer.parseInt(br.readLine());

		// 각 운동기구의 근손실 정도를 배열에 담는다
		long[] arr = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		// 배열을 정렬한다
		Arrays.sort(arr);

		// 맨앞, 맨뒤를 한 그룹으로 묶는다
		// n이 홀수라면 최대값을 빼고 생각한다
		long ans = Long.MIN_VALUE;
		int end = n;
		if (n % 2 != 0) {
			ans = Math.max(ans, arr[n - 1]);
			end = n - 1;
		}

		for (int i = 0; i < end / 2; i++) {
			ans = Math.max(ans, arr[i] + arr[end - i - 1]);
		}

		System.out.println(ans);

	}

}
