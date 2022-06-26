import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        sc.close();
        int ans = 0;
        if(a == b && b == c) {
            ans = 10000 + a*1000;
        }else if(a == b && b != c) {
            ans = 1000 + a*100;
        }else if(b == c && c != a) {
            ans = 1000 + b*100;
        }else if(c == a && a != b) {
            ans = 1000 + c*100;
        }else{
            ans = Math.max(a*100, Math.max(b*100, c*100));
        }

        System.out.println(ans);
    }

}
