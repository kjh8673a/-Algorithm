import java.util.Arrays;
import java.util.Scanner;

public class Main {       
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();
        sc.close();

        Arrays.sort(arr);

        if(arr[0] + arr[1] > arr[2]) {
            System.out.println(arr[0] + arr[1] + arr[2]);
        }else{
            arr[2] = arr[0] + arr[1] - 1;
            System.out.println(arr[0] + arr[1] + arr[2]);
        }

    }
}
