import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        int[] diff = new int[n-1];
        
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < n-1; i++) {
            diff[i] = arr[i+1] - arr[i];
        }

        sc.close();

        Arrays.sort(diff);

        int ans = 0;

        for(int i = 0; i < n-k; i++) {
            ans += diff[i];
        }

        System.out.println(ans);
        
    }
}