import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());

        BigInteger x = (a.subtract(b)).divide(BigInteger.TWO);

        System.out.println(b.add(x));
        System.out.println(x);
    }

}