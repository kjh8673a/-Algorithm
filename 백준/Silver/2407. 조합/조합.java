import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	static BigInteger[] fact;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st =  new StringTokenizer(br.readLine());
		// nCm = n! / (n-m)!m!
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		fact = new BigInteger[n+1];
		fact[0] = fact[1] = BigInteger.ONE;

		factorial(n);

		BigInteger ans = fact[n].divide(fact[n-m].multiply(fact[m]));

		System.out.println(ans);

	}

	public static BigInteger factorial(int num) {
		if(fact[num] != null) {
			return fact[num];
		}

		return fact[num] = BigInteger.valueOf(num).multiply(factorial(num-1));
	}

}