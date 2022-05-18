import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        int[] t = new int[n+10];
        int[] p = new int[n+10];
        for(int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        sc.close();

        int dp[] = new int[n+10];
        int max = 0;

        for(int i = 0; i < n; i++) {
            max = i+t[i];
            if(max <= n+1) {
                for(int j = n; j >= max; j--){
                    if(dp[j]<p[i]+dp[i]){
                        dp[j]=p[i]+dp[i];
                    }
                }
            }

        }

        System.out.println(dp[n]);

    }
}