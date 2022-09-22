import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	static BigInteger mod = new BigInteger("1000000007");
	static BigInteger c, rr;
	static BigInteger one = new BigInteger("1");
	static BigInteger two = new BigInteger("2");

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		BigInteger n = new BigInteger(st.nextToken());
		BigInteger r = new BigInteger(st.nextToken());
		BigInteger r2 = n.subtract(r);

		BigInteger b = null;
		c = null;
		rr = null;
		if (r.compareTo(r2) == 1) { // r > r2
			rr = r2;
			c = factorial(r2).remainder(mod);
			b = fac2(r).remainder(mod);
		} else {
			rr = r;
			c = factorial(r).remainder(mod);
			b = fac2(r2).remainder(mod);
		}

		BigInteger a = fac2(n).remainder(mod);

		BigInteger p = pow(b.multiply(c).remainder(mod), mod.subtract(two)).remainder(mod);

		BigInteger ans = a.multiply(p).remainder(mod);

		System.out.println(ans);

	}

	private static BigInteger pow(BigInteger i, BigInteger j) {

		if (j.equals(one)) {
			return i;
		}

		BigInteger half = pow(i, j.divide(two)).remainder(mod);

		if (j.remainder(two).equals(one)) {
			return half.multiply(half).remainder(mod).multiply(i).remainder(mod);
		} else {
			return half.multiply(half).remainder(mod);
		}

	}

	private static BigInteger factorial(BigInteger num) {

		if (num.intValue() == 0 || num.intValue() == 1) {
			return one;
		}

		BigInteger now = one;

		for (int i = 1; i <= num.intValue(); i++) {
			now = now.multiply(BigInteger.valueOf(i)).remainder(mod);
		}

		return now.remainder(mod);
	}

	private static BigInteger fac2(BigInteger num) {

		if (num.intValue() == 0 || num.intValue() == 1) {
			return one;
		}

		if (num.equals(rr)) {
			return c.remainder(mod);
		}

		BigInteger now = c;

		for (int i = rr.intValue() + 1; i <= num.intValue(); i++) {
			now = now.multiply(BigInteger.valueOf(i)).remainder(mod);
		}

		return now.remainder(mod);
	}

}