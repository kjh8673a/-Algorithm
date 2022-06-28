import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int n = sc.nextInt();
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        sc.close();

        for(int i = 0; i < 26; i++) {
            String decode = "";
            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j)+i > 122) {
                    decode += (char)(str.charAt(j)+i-26);
                }else{
                    decode += (char)(str.charAt(j)+i);
                }
            }
            for(int j = 0; j < n; j++) {
                if(decode.contains(arr[j])){
                    System.out.println(decode);
                    return;
                }
            }
        }
    }
}
