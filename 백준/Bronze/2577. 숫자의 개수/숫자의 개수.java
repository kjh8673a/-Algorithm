import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		int[] arr = new int[10];
		
		int num = A * B * C;
		
		while(num > 0) {
			arr[num % 10]++;
			num /= 10;
		}
		for(int i = 0; i < 10; i++) {
			System.out.println(arr[i]);
		}
		
		sc.close();
	}
	
}