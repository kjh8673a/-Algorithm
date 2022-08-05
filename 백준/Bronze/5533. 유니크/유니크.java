import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][3];

        for(int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }
        sc.close();

        int[] score = new int[n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                int a = arr[i][j];
                for(int k = 0; k < n; k ++) {
                    if(arr[i][j] == arr[k][j] && i != k) {
                        a = 0;
                        break;
                    }
                }
                score[i] += a;
            }
        }

        for(int i = 0; i < n; i++) {
            System.out.println(score[i]);
        }
    }
}
