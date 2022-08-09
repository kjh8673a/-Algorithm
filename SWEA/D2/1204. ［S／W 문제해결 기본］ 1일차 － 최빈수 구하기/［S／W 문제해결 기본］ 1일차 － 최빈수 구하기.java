import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i = 0; i < t; i++) {
            int num = sc.nextInt();

            int[] scores = new int[101];
            int[] sort = new int[101];
            for(int j = 0; j < 1000; j++) {
                int s = sc.nextInt();
                scores[s]++;
                sort[s]++;
            }

            Arrays.sort(sort);

            for(int j = 100; j >= 0; j--) {
                if(sort[100] == scores[j]) {
                    System.out.println("#" + num + " " + j);
                    break;
                }
            }
        }

        sc.close();
    }
}
