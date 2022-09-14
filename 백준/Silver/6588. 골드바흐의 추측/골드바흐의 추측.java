import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			int num = Integer.parseInt(br.readLine());

			if (num == 0) {
				break;
			}

			// 2부터 시작해서 i와 num-i가 소수인지 확인한다
			boolean isGoldbach = false;
			for (int i = 2; i <= num / 2; i++) {
				if (isPrime(i) && isPrime(num - i)) {
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