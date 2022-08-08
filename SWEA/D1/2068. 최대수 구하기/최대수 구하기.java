import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
	
		for(int i = 0; i < t; i++) {
			int[] arr = new int[10];
			for(int j = 0; j < 10; j++) {
				arr[j] = sc.nextInt();
			}
			Arrays.sort(arr);

			System.out.println("#" + (i+1) + " " + arr[9]);

		}
		
		sc.close();

	}
}