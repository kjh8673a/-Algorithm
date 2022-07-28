import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int distance = 0;
			int a = 0;
			int b = 0;
			for (int j = 0; j < n; j++) {
				a = sc.nextInt();
				if (a == 1) {
					b += sc.nextInt();
					distance += b;
				} else if (a == 2) {
					b -= sc.nextInt();
					if (b < 0)
						b = 0;
					distance += b;
				} else {
					distance += b;
				}
			}
			System.out.println("#" + (i + 1) + " " + distance);
		}
		
		sc.close();
	}
}