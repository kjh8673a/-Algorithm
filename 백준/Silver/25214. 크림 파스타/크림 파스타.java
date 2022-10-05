import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n];
		int min = 0;

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken());
			if (i == 0) {
				dp[0] = 0;
				min = a;
			} else {
				min = Math.min(a, min);
				dp[i] = Math.max(a - min, dp[i - 1]);
			}
		}

		for (int i = 0; i < n; i++) {
			sb.append(dp[i] + " ");
		}

		System.out.println(sb.toString());
	}

}