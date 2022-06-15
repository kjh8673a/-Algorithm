import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[6];
        for(int i = 0; i < 6; i++) {        
            arr[i] = sc.nextInt();
        }
        
        sc.close();

        arr[0] = 1-arr[0];
        arr[1] = 1-arr[1];
        arr[2] = 2-arr[2];
        arr[3] = 2-arr[3];
        arr[4] = 2-arr[4];
        arr[5] = 8-arr[5];

        for(int i = 0; i < 6; i++) {
            System.out.print(arr[i] + " ");
        }
        
    }
}