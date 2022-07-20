import java.util.Scanner;

public class Main {       
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int a = sc.nextInt();
        int B = sc.nextInt();
        int b = sc.nextInt();
        int P = sc.nextInt();

        if(A + B <= P || (P >= B && b >= A) || (P >= A && a >= B) ) {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }

        sc.close();
        
    }
}
