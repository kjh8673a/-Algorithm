import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        sc.close();

        int ans = 1;

        for (int i = 0; i < s.length(); i++) {
            if(ans == 1) {
                if(s.charAt(i) == 'A') {
                    ans = 2;
                    continue;
                }
                if(s.charAt(i) == 'C') {
                    ans = 3;
                    continue;
                }
            }

            if(ans == 2) {
                if(s.charAt(i) == 'B') {
                    ans = 3;
                    continue;
                }
                if(s.charAt(i) == 'A') {
                    ans = 1;
                    continue;
                }
            }

            if(ans == 3) {
                if(s.charAt(i) == 'C') {
                    ans = 1;
                    continue;
                }
                if(s.charAt(i) == 'B') {
                    ans = 2;
                    continue;
                }
            }
        }

        System.out.println(ans);
    }

}
