import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr_x = new int[n];
        int[] arr_y = new int[n];
        for(int i = 0; i < n; i++) {
            arr_x[i] = sc.nextInt();
            arr_y[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(arr_x);
        Arrays.sort(arr_y);
        
        System.out.println((arr_x[n-1]-arr_x[0])*(arr_y[n-1]-arr_y[0]));
    }
}
