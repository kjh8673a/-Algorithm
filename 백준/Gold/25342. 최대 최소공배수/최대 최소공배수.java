import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			long N = Integer.parseInt(br.readLine());

			long[] arr = {
					lcm(N, lcm(N - 1, N - 2)),
					lcm(N, lcm(N - 1, N - 3)),
					lcm(N, lcm(N - 2, N - 3)),
					lcm(N - 1, lcm(N - 2, N - 3))
			};

			Arrays.sort(arr);
			sb.append(arr[3]).append("\n");
		}

		System.out.println(sb.toString());

	}

	public static long gcd(long a, long b) {
		while (b != 0) {
			long r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

	public static long lcm(long a, long b) {
		return a * b / gcd(a, b);
	}

}