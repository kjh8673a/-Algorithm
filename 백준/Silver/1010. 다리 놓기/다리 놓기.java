import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            BigInteger n = sc.nextBigInteger();
            BigInteger m = sc.nextBigInteger();

            System.out.println(fact(m).divide(fact(n).multiply(fact(m.subtract(n)))));            
        }
        sc.close();
    }

    private static BigInteger fact(BigInteger num) {
        BigInteger one = new BigInteger("1");
        if(num.intValue() == 0 || num.intValue() == 1) {
            return one;
        }else{
            return fact(num.subtract(one)).multiply(num);
        }
    }
}