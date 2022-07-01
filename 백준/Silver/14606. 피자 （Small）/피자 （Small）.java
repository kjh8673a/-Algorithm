import java.util.Scanner;

public class Main {
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        sc.close();

        devide(n);

        System.out.println(ans);
    }

    public static void devide(int n) {
        if(n == 1) {
            ans += 0;
        }else if(n % 2 == 0) {
            ans += (n/2)*(n/2);
            devide(n/2);
            devide(n/2);
        }else{
            ans += ((n+1)/2)*((n-1)/2);
            devide((n+1)/2);
            devide((n-1)/2);
        }
    }

}