import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        int b;
        a = sc.nextInt(); // A 입력
        b = sc.nextInt(); // B 입력

        System.out.println(a + b); // A+B 출력
        sc.close();
    }
}