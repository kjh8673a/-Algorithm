import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();
        sc.close();

        a = a.replaceAll("A|E|F|H|I", "3");
        a = a.replaceAll("B|D|G|J|K|M|N|P|Q|R|T|X|Y", "2");
        a = a.replaceAll("C|L|O|S|U|V|W|Z", "1");
        b = b.replaceAll("A|E|F|H|I", "3");
        b = b.replaceAll("B|D|G|J|K|M|N|P|Q|R|T|X|Y", "2");
        b = b.replaceAll("C|L|O|S|U|V|W|Z", "1");
        
        String s = "";
        for(int i = 0; i < a.length(); i++) {
            s += a.charAt(i);
            s += b.charAt(i);
        }

        while(s.length() > 2) {
            String tmp = "";
            for(int i = 0; i < s.length()-1; i++) {
                int n = (s.charAt(i)-'0') + (s.charAt(i+1)-'0');
                tmp += Integer.toString(n%10);
            }
            s = tmp;
        }
        System.out.println(s);
    }
}