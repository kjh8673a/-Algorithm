import java.util.Scanner;

public class Main {
    static boolean visit[];
    static int n;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for(int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        int[] dp = new int[n+1];

        dp[1] = arr[1];
        
        for(int i = 2; i <= n; i++) {
            dp[i] = arr[i];
            for(int j = 1; j < i; j++) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j] + arr[i], dp[i]);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            if(max <= dp[i]) {
                max = dp[i];
            }
        }

        
        System.out.println(max);
    }


}