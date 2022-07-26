import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        int i = 0;
        int tmp = n;
        while (i >= 0) {
            n = (n%10)*10 + (n/10 +n%10)%10;
            i++;

            if(tmp == n) {
                break;
            }
        }
        System.out.println(i);

    }
}