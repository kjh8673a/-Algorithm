import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		// 1000000까지 숫자를 소수 판별하여 배열에 넣는다
		boolean[] primes = new boolean[1000001];
		for (int i = 1; i < 1000001; i++) {
			if (isPrime(i)) {
				primes[i] = true;
			}
		}

		while (true) {
			int num = Integer.parseInt(br.readLine());

			if (num == 0) {
				break;
			}

			// 2부터 시작해서 i와 num-i가 소수인지 확인한다
			boolean isGoldbach = false;
			for (int i = 2; i <= num / 2; i++) {
				if (primes[i] && primes[num - i]) {
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
	public static boolean isPrime(int x) {
		if (x == 1) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(x); i++) {
			if (x % i == 0) {
				return false;
			}
		}
		return true;
	}

}