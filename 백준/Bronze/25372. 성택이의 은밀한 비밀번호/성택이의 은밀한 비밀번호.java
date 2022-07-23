import java.util.Scanner;

public class Main {       
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i < t; i++) {
            String str = sc.next();
            if(str.length() >= 6 && str.length() <= 9) {
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }

        sc.close();

    }
}
