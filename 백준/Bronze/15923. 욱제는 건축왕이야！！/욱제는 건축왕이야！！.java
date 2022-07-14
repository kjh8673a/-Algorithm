import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][2];
		int len = 0;
		for(int i = 0; i < n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			if(i >= 1) {
				len += Math.abs(arr[i][0] - arr[i-1][0]) + Math.abs(arr[i][1] - arr[i-1][1]);
			}			
		}
		sc.close();
		len += Math.abs(arr[n-1][0] - arr[0][0]) + Math.abs(arr[n-1][1] - arr[0][1]);
		System.out.println(len);
	}
}