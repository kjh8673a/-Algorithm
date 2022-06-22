import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int c = sc.nextInt();
            int q = 0;
            int d = 0;
            int n = 0;

            if(c >= 25) {
                q = c / 25;
                c -= 25 * q;
            }

            if(c >= 10) {
                d = c / 10;
                c -= 10 * d;
            }

            if(c >= 5) {
                n = c / 5;
                c -= 5 * n;
            }

            System.out.println(q + " " + d + " " + n + " " + c);
        }

        sc.close();
    }
}