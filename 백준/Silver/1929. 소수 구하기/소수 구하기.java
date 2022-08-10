import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.close();
    
        if(m == 1) {
            m = 2;
        }

        int sosu[] = new int[n-m+1];

        for (int i = m; i <= n; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0) {
                    sosu[i-m]++;
                    break;
                }
            }
        }

        for (int i = 0; i < sosu.length; i++) {
            if(sosu[i] == 0) {
                System.out.println(i+m);
            }
        }
        
    }
}
