import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        BigInteger n = new BigInteger(st.nextToken());
        BigInteger k = new BigInteger(st.nextToken());

        BigInteger ans = factorial(n).divide(factorial(k).multiply(factorial(n.subtract(k))));

        BigInteger dev = new BigInteger("10007");

        System.out.println(ans.remainder(dev));

    }

    public static BigInteger factorial(BigInteger num) {
        BigInteger one = new BigInteger("1");
        if (num.intValue() == 0 || num.intValue() == 1) {
            return one;
        } else {
            return factorial(num.subtract(one)).multiply(num);
        }
    }

}