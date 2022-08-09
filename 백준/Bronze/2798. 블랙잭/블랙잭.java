import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        Arrays.sort(arr);
        
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int ans = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j) {
                    for(int k = 0; k < n; k++) {
                        if(i != k && j != k) {
                            sum = arr[i] + arr[j] + arr[k];
                            if(sum > m) break;
                            else if(sum <= m && min != Math.min(min, m-sum)) {
                                min = Math.min(min, m-sum);
                                ans = sum;
                            }
                        }
                    }
                }
                
            }
        }

        System.out.println(ans);
        


    }

}