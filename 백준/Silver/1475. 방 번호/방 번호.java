import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];
        int n = sc.nextInt();
        sc.close();
        if(n != 0) {
            while(n!=0) {
                if(n%10 == 6) {
                    arr[9]++;
                }else{
                    arr[n%10]++;
                }
                n /= 10;
            }
    
            int cnt1 = 0;
            for(int i = 0; i < arr.length-1; i++) {
                if(cnt1 <= arr[i]) {
                    cnt1 = arr[i];
                }
            }
    
            int cnt2 = 0;
            if(arr[9]%2 == 0) {
                cnt2 = arr[9]/2;
            }else{
                cnt2 = arr[9]/2 + 1;
            }
    
            int ans = Math.max(cnt1, cnt2);

            System.out.println(ans);
        }else{
            int ans = 1;
            System.out.println(ans);
        }
        
    }
}