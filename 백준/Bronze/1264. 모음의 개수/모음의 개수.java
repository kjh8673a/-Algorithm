import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = 0;
        char c = ' ';
        char ca = 'a';
        char ce = 'e';
        char ci = 'i';
        char co = 'o';
        char cu = 'u';
        while(true) {
            String str = sc.nextLine().toLowerCase();

            if(str.equals("#")) {
                break;
            }

            for(int i = 0; i < str.length(); i++) {
                c = str.charAt(i);
                if(c == ca || c == ce || c == ci || c == co || c == cu) {
                    cnt++;
                }
            }

            System.out.println(cnt);
            cnt = 0;
        }
        
        sc.close();
    }
}