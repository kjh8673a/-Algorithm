import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int max = n * (n - 1) / 2;

		int[] teams = new int[n];
		int sum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			teams[i] = Integer.parseInt(st.nextToken());
			sum += teams[i];
		}

		if (sum != max) {
			System.out.println(-1);
		} else {
			Arrays.sort(teams);

			boolean isOk = true;
			int left = 0;
			for (int i = n - 1; i >= 0; i--) {
				int now = teams[i];
				if (now > i) {
					if (i + left < now) {
						isOk = false;
						break;
					} else {
						left -= now - i;
					}

				} else if (now == i) {
					continue;
				} else {
					left += i - now;
				}
			}

			if (isOk) {
				System.out.println(1);
			} else {
				System.out.println(-1);
			}
		}

	}

}