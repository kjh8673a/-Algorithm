import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(fac(1, N));
    }

    private static BigInteger fac(int a, int b) {
        BigInteger tmp = BigInteger.valueOf(a);

        if (a < b) {
            int m = (a + b) / 2;
            tmp = fac(a, m).multiply(fac(m + 1, b));
        }

        return tmp;
    }

}