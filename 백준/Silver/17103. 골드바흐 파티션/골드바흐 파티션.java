import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 1000000까지 숫자를 소수 판별하여 배열에 넣는다
		boolean[] notPrimes = new boolean[1000001];
		notPrimes = isNotPrime(notPrimes, 1000000);

		// 테스트 케이스의 개수
		int t = Integer.parseInt(br.readLine());

		for(int i = 0; i < t; i++) {
			int num = Integer.parseInt(br.readLine());

			// j와 num-j가 모두 소수라면 cnt++
			int cnt = 0;
			for (int j = 2; j <= num / 2; j++) {
				if (!notPrimes[j] && !notPrimes[num - j]) {
					cnt++;
				}
			}

			sb.append(cnt).append("\n");
		}

		System.out.println(sb.toString());

	}

	// 소수 판별
	static boolean[] isNotPrime(boolean[] b, int n) {
		b[0] = true;
		b[1] = true;

		for (int i = 2; i < Math.sqrt(n); i++) {
			if (!b[i]) {
				for (int j = i * i; j <= n; j += i) {
					b[j] = true;
				}
			}
		}

		return b;
	}

}