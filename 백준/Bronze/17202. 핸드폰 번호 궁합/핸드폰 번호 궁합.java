import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        String b = sc.nextLine();
        sc.close();

        String s = "";
        for(int i = 0; i < a.length(); i++) {
            s += a.charAt(i);
            s += b.charAt(i);
        }
        while(s.length() > 2) {
            String tmp = "";
            for(int i = 0; i < s.length()-1; i++) {
                int n = (s.charAt(i) - '0') + (s.charAt(i+1) - '0');
                tmp += Integer.toString(n%10);
            }
            s = tmp;
        }
        System.out.println(s);

    }
}