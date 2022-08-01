import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int x1 = 1;
        int y1 = 1;
        int z1 = 1;
        int x2 = 1000;
        int y2 = 1000;
        int z2 = 1000;

        for(int i = 0; i < n; i++) {
            x1 = Math.max(x1, sc.nextInt());
            y1 = Math.max(y1, sc.nextInt());
            z1 = Math.max(z1, sc.nextInt());
            x2 = Math.min(x2, sc.nextInt());
            y2 = Math.min(y2, sc.nextInt());
            z2 = Math.min(z2, sc.nextInt());
        }
        sc.close();
        int ans = 0;
        if(x1 > x2 || y1 > y2 || z1 > z2) {
            ans = 0;
        } else{
            ans = (x2-x1)*(y2-y1)*(z2-z1);
        }
        
        System.out.println(ans);

    }
}
