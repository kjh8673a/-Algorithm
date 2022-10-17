import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		long[] dp = new long[n];

		Arrays.fill(dp, 1);

		for (int i = 3; i < n; i++) {
			dp[i] = dp[i - 1] + dp[i - 3];
		}

		System.out.println(dp[n - 1]);
	}

}