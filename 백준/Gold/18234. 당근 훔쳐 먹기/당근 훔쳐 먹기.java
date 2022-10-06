import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		long[][] carrot = new long[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			// 처음 당근
			carrot[i][0] = Integer.parseInt(st.nextToken());
			// 영양제
			carrot[i][1] = Integer.parseInt(st.nextToken());
		}

		// 영양제 기준으로 오름차순 정렬
		Arrays.sort(carrot, new Comparator<long[]>() {
			@Override
			public int compare(long[] o1, long[] o2) {
				return Long.compare(o1[1], o2[1]);
			}
		});

		long ans = 0;
		for (int i = 0; i < n; i++) {
			ans += carrot[i][0] + carrot[i][1] * (t - n + i);
		}

		System.out.println(ans);

	}

}