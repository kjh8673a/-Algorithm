import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		String str = br.readLine();

		BigInteger num = new BigInteger("0");
		for(int i = 0; i < n; i++) {
			int ch = str.charAt(i) - 'a' + 1;

			num = num.add(BigInteger.valueOf(ch).multiply(BigInteger.valueOf(31).pow(i)));
		}

		System.out.println(num.remainder(BigInteger.valueOf(1234567891)));

	}

}