import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int ans = n;
        
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            int[] arr = new int[26];
            arr[s.charAt(0)-97] = 1;
            for(int j = 1; j < s.length(); j++) {
                if (s.charAt(j-1) != s.charAt(j)) {
                    if(arr[s.charAt(j)-97] != 0) {
                        ans--;
                        break;
                    }
                }
                arr[s.charAt(j)-97]++;
            }
        }
        sc.close();
        
        System.out.println(ans);
    }
}
