import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, ans;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		arr = new int[n + 1][2];
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		ans = 0;

		work(1, 0);

		System.out.println(ans);

	}

	public static void work(int day, int total) {
		if (day >= n + 1) {
			ans = Math.max(ans, total);
			return;
		}

		// 날짜 + 기간이 n+1보다 작거나 같을때만 일을 할수있다
		if (day + arr[day][0] <= n + 1) {
			work(day + arr[day][0], total + arr[day][1]);
		}

		// 일을 안하고 다음날로 넘어간다
		work(day + 1, total);

	}

}