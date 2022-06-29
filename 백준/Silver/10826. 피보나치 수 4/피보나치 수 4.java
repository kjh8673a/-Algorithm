import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.close();

        BigInteger[] arr = new BigInteger[n+2];
        arr[0] = new BigInteger("0");
        arr[1] = new BigInteger("1");

        for(int i = 2; i <= n; i++) {
            arr[i] = arr[i-1].add(arr[i-2]);
        }

        System.out.println(arr[n]);

    }
}