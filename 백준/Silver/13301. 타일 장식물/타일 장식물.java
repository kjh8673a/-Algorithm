import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt()+1;
        sc.close();

        long[] arr = new long[n+2];
        arr[0] = 0;
        arr[1] = 1;

        for(int i = 2; i <= n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }

        long garo = arr[n];
        long sero = arr[n-1];

        System.out.println(2*(garo+sero));

    }

}