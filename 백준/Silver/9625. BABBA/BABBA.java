import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        sc.close();

        int a = 1;
        int b = 0;
        int cur_a = 1;
        int cur_b = 0;

        if(n >= 1) {
            for(int i = 0; i < n; i++){
                cur_a = b;
                cur_b = a + b;
                a = cur_a;
                b = cur_b;
            }
        }

        System.out.println(cur_a + " " + cur_b);
        
    }
}