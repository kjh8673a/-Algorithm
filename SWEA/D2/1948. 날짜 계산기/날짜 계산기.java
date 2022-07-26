import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		int t = sc.nextInt();
		
		for(int i = 0; i < t; i++) {
			int m1 = sc.nextInt();
			int d1 = sc.nextInt();
			int m2 = sc.nextInt();
			int d2 = sc.nextInt();
			
			for(int j = m2-1; j >= m1; j--) {
				d2 += month[j-1];
			}
			
			System.out.println("#" + (i+1) + " " + (d2 - d1 + 1));
		}
		
		sc.close();
	}
}