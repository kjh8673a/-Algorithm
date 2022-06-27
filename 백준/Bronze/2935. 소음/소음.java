import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger a = sc.nextBigInteger();
        String s = sc.next();
        BigInteger b = sc.nextBigInteger();
        sc.close();

        if(s.equals("*")) {
            System.out.println(a.multiply(b));
        }

        if(s.equals("+")) {
            System.out.println(a.add(b));
        }
    }

}
