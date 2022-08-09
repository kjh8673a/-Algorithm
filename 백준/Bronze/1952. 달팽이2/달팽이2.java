import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        sc.close();

        int ans = 0;
        int idx = 1;
        while(true) {
            if(m == 1 || n == 1) {
                ans++;
                break;
            }
            if(idx % 2 != 0) {
                ans++;
                m--;
            }else if(idx % 2 == 0) {
                ans++;
                n--;
            }
            idx++;      
        }

        System.out.println(ans);

    }

}