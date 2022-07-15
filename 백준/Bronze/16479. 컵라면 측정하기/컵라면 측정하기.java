import java.util.Scanner;

public class Main {       
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double k = sc.nextDouble();
        double d1 = sc.nextDouble();
        double d2 = sc.nextDouble();
        sc.close();
        System.out.println(Math.pow(k, 2) - Math.pow((d1-d2)/2,2));
    }
}
