import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < n; i++) {
            String str = sc.nextLine();
            int cnt = 0;
            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == ' ') {
                    cnt++;
                }
            }
            String[] arr = new String[cnt+1];
            String a = "";
            int idx = 0;
            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == ' ') {
                    arr[idx] = a;
                    idx++;
                    a = "";
                }else if(j == str.length()-1) {
                    a += str.charAt(j);
                    arr[idx] = a;
                }else {
                    a += str.charAt(j);
                }
            }

            System.out.print("Case #" + (i+1) + ": ");
            for(int j = arr.length-1; j >= 0; j--) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();

        }

        sc.close();
    }
}
