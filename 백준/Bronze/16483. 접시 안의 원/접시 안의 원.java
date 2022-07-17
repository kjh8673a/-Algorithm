import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(Math.round(Math.pow(sc.nextDouble()/2, 2)));
        sc.close();
    }
}