import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		long[] arr = new long[n];
		long[] remainder = new long[m];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (i == 0) {
				arr[i] = num % m;
			} else {
				arr[i] = (arr[i - 1] + num) % m;
			}
			remainder[(int) arr[i]]++;
		}

		long cnt = 0;
		for(int i = 0; i < m; i++) {
			if(remainder[i] > 1) {
				// 조합(nCr 식 정리)
				cnt += remainder[i] * (remainder[i] - 1) / 2;
			}
		}

		cnt += remainder[0];

		System.out.println(cnt);

	}

}