import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		
		for(int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] arr = new int[n][n];
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			
			int max = 0;
			
			for(int j = 0; j < n-m+1; j++) {
				for(int k = 0; k < n-m+1; k++) {
					int sum = 0;
					for(int l = j; l < j+m; l++) {
						for(int p = k; p < k+m; p++) {
							sum += arr[l][p];
						}
					}
					max = Math.max(max, sum);
				}
			}
			
			System.out.println("#" + (i+1) + " " + max);
			
		}
		
		sc.close();
	}
}