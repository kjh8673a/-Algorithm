import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] hp = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			hp[i] = Integer.parseInt(st.nextToken());
		}

		int[] joy = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			joy[i] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[N + 1][100];

		for (int i = 1; i < N + 1; i++) {
			int cost = hp[i];
			int value = joy[i];
			for (int j = 0; j < 100; j++) {
				if (cost <= j) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost] + value);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		System.out.println(dp[N][99]);

	}

}