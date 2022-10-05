import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] dp = new int[k + 1];
		dp[a] = 0;
		for (int i = a + 1; i < k + 1; i++) {
			if (i % 2 == 0 && i / 2 >= a) {
				dp[i] = Math.min(dp[i - 1], dp[i / 2]) + 1;
			} else {
				dp[i] = dp[i - 1] + 1;
			}
		}

		System.out.println(dp[k]);

	}

}