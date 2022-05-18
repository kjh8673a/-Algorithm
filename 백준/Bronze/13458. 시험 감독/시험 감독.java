import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            arr[i] = a;
        }
        
        int b = sc.nextInt();
        int c = sc.nextInt();

        sc.close();


        long cnt = 0;
        for(int i = 0; i < n; i++) {
            cnt++;
            if(arr[i]-b > 0) {
                cnt += (arr[i]-b)/c;
                if((arr[i]-b)%c > 0) {
                    cnt++;
                }
            }else{
                continue;
            }
        }

        System.out.println(cnt);

    }
}