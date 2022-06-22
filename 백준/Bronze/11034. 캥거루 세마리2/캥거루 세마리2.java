import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()){

            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if(b - a >= c - b) {
                System.out.println(b - a - 1);
            }else{
                System.out.println(c - b - 1);
            }

            continue;
        }

        
    }
}