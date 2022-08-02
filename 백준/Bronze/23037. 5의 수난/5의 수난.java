import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sum = 0;
        while(n > 0) {
            sum += Math.pow(n % 10, 5);

            n /= 10;
        }

        System.out.println(sum);

        sc.close();
    }
}
