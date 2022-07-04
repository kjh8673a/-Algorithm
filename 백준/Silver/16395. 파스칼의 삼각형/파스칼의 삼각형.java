import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();

        System.out.println(comb(n-1,k-1));
    }

    public static int comb(int n, int k) {
        if(n == k || k == 0) {
            return 1;
        }else {
            return comb(n-1, k-1) + comb(n-1, k);
        }
    }
}