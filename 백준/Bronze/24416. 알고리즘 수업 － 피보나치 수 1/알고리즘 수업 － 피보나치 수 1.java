import java.util.Scanner;

public class Main {

    static int[] f;
    static int fib_cnt;
    static int fibonacci_cnt;

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.close();
        
        f = new int[n+1];
        for(int i = 0; i < n+1; i++) {
            f[i] = -1;
        }
        f[0] = 1;
        f[1] = 1;

        fib(n);
        fibonacci(n);

        System.out.println((fib_cnt+1) + " " + (fibonacci_cnt-1));

    }

    public static int fib(int n) {
        fib_cnt++;
        if (n == 1 || n == 2) {
            fib_cnt--;
            return 1;
        }else {
            return (fib(n-1)+fib(n-2));
        }
    }

    public static int fibonacci(int n) {
        if(f[n] == -1) {
            f[n] = fibonacci(n-1) + fibonacci(n-2);
            fibonacci_cnt++;
        }
        return f[n];
    }
}