import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int n = sc.nextInt();
            
            int[] room = new int[n+1];

            int idx = 1;
            while(idx <= n) {
                for(int j = 1; j < n+1; j++) {
                    if(j % idx == 0) {
                        room[j] = (room[j] == 0) ? 1 : 0;
                    }
                }
                idx++;
            }
            
            int ans = 0;
            for(int j = 1; j < n+1; j++) {
                if(room[j] == 1) {
                    ans++;
                }
            }
            System.out.println(ans);
        }

        sc.close();
    }
}
