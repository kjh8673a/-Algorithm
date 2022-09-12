import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= 9; i++) {
			if (isPrime(i)) {
				solve(n - 1, i);
			}
		}

		System.out.println(sb.toString());

	}

	public static void solve(int num, int val) {

		if (num == 0) {
			if (isPrime(val)) {
				sb.append(val).append("\n");
				return;
			}
		} else {
			for (int i = 0; i < 10; i++) {
				if (isPrime(val)) {
					solve(num - 1, val * 10 + i);
				}
			}
		}
	}

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
