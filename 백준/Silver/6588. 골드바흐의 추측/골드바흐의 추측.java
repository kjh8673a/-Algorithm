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

		while (true) {
			int num = Integer.parseInt(br.readLine());

			if (num == 0) {
				break;
			}

			// 2부터 시작해서 i와 num-i가 소수인지 확인한다
			boolean isGoldbach = false;
			for (int i = 2; i <= num / 2; i++) {
				if (!notPrimes[i] && !notPrimes[num - i]) {
					sb.append(num + " = " + i + " + " + (num - i)).append("\n");
					isGoldbach = true;
					break;
				}
			}

			if (!isGoldbach) {
				sb.append("Goldbach's conjecture is wrong.").append("\n");
			}
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