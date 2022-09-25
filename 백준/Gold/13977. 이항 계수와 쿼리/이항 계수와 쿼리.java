import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long mod = 1000000007;
	static long[] fac;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 팩토리얼 구하는 과정을 메서드를 따로 구현하여 매번 호출하면 시간초과가 난다
		// 팩토리얼을 미리 배열에 넣어주고 배열의 값을 꺼내온다
		fac = new long[4000001];
		fac[0] = fac[1] = 1;
		for (int i = 2; i < 4000001; i++) {
			fac[i] = fac[i - 1] * i % mod;
		}

		int m = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			long p = pow(fac[n - r] * fac[r] % mod, mod - 2) % mod;

			long ans = fac[n] * p % mod;

			sb.append(ans).append("\n");
		}

		System.out.println(sb.toString());

	}

	private static long pow(long i, long j) {

		if (j == 1) {
			return i % mod;
		}

		long half = pow(i, j / 2) % mod;

		if (j % 2 == 1) {
			return half * half % mod * i % mod;
		} else {
			return half * half % mod;
		}

	}

}