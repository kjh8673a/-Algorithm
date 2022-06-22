import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int m = sc.nextInt();
            int n = sc.nextInt();

            int[] a = new int[m];
            int[] b = new int[n];
            for(int j = 0; j < m; j++) {
                a[j] = sc.nextInt();
            }
            for(int j = 0; j < n; j++) {
                b[j] = sc.nextInt();
            }

            if(m <= n) {
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
        sc.close();
    }
}