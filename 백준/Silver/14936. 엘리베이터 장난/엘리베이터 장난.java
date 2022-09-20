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

		int t1 = n;
		int t2 = n / 2;
		int t3 = (n+1)/2;
		int t4 = (n - 1) / 3 + 1;

		int ans = 0;

		// 아무것도 안함
		ans++;

		// 동작 1
		if (t1 <= m) {
			ans++;
		}

		// 동작 2
		if (t2 <= m && n > 1) {
			ans++;
		}

		// 동작 3
		if (t3 <= m && n > 1) {
			ans++;
		}

		// 동작 4
		if (t4 <= m && n > 2) {
			ans++;
		}

		// 동작 2 + 동작 4
		if (t2 + t4 <= m && n >= 3) {
			ans++;
		}

		// 동작 3 + 동작 4
		if (t3 + t4 <= m && n >= 3) {
			ans++;
		}

		// 동작 4 + 동작 1
		if (t4 + t1 <= m && n >= 3) {
			ans++;
		}

		System.out.println(ans);

	}

}