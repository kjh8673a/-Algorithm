import java.util.Scanner;

public class Solution {       
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();

        if(a % 3 == (b+1) % 3) {
            System.out.println("A");
        }else if((a+1) % 3 == b % 3) {
            System.out.println("B");
        }
        
    }
}
