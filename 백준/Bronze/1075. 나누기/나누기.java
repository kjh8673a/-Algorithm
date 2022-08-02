import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int f = sc.nextInt();

        n /= 100;
        n *= 100;

        for(int i = n; i < n+100; i++) {
            if(i % f == 0) {
                System.out.println(String.format("%02d", i%100));
                break;
            }
        }
        
        sc.close();


    }
}
