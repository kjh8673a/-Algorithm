import java.util.Scanner;

public class Main {
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        sc.close();

        int f = n / 5;
        int t = (n % 5) / 2;

        if((n % 5) % 2 != 0) {
            for(int i = n/5; i >= 0; i--) {
                if((n-5*i)%2 == 0) {
                    f = i;
                    t = (n-5*i) / 2;
                    break;
                }else {
                    f = 0;
                    t = -1;
                }
            }
        }
        System.out.println(f+t);
    }
}