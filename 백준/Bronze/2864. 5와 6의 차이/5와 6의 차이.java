import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();
        
        sc.close();

        String max_a = "";
        String min_a = "";
        for(int i = 0; i < a.length(); i++) {
            if(a.charAt(i)-48 == 5 || a.charAt(i)-48 == 6) {
                max_a += "6";
                min_a += "5";
            }else{
                max_a += a.charAt(i);
                min_a += a.charAt(i);
            }
        }

        String max_b = "";
        String min_b = "";
        for(int i = 0; i < b.length(); i++) {
            if(b.charAt(i)-48 == 5 || b.charAt(i)-48 == 6) {
                max_b += "6";
                min_b += "5";
            }else{
                max_b += b.charAt(i);
                min_b += b.charAt(i);
            }
        }

        int max = Integer.valueOf(max_a) + Integer.valueOf(max_b);
        int min = Integer.valueOf(min_a) + Integer.valueOf(min_b);

        System.out.println(min + " " + max);

    }

}