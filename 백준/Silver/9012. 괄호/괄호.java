import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            String str = sc.next();

            String ans = "YES";
            int check = 0;
            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == '(') {
                    check++;
                }else if(str.charAt(j) == ')') {
                    check--;
                }
                if(check < 0) {
                    ans = "NO";
                    break;
                }
            }
            if(check != 0) {
                ans = "NO";
            }

            System.out.println(ans);
        }
        
        
        sc.close();

    }
}