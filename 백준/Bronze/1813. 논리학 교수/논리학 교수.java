import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n+1]; 

        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();

            if(a > n) continue;
            else arr[a]++;            
        }

        int ans = -1;
        for(int i = arr.length-1; i >= 0; i--) {
            if(i == arr[i]) {
                ans = i;
                break;
            }
        }
        
        System.out.println(ans);
        
        sc.close();

    }
}