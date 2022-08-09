import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;

        int[] arr = new int[9];

        for(int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        sc.close();

        Arrays.sort(arr);

        int a = 0;
        int b = 0;
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(i != j && sum - 100 - arr[i] == arr[j]) {
                    a = i;
                    b = j;
                }
            }
        }

        for(int i = 0; i < 9; i++) {
            if(i != a && i != b) {
                System.out.println(arr[i]);
            }
        }
    }
}