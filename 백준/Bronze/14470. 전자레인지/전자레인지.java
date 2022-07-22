import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		int E = sc.nextInt();
		sc.close();
		
		int ans = 0;
		if(A < 0) {
			if(B < 0) {
				ans = (B-A)*C;
			}else {
				ans = (0-A)*C + D + (B-0)*E;
			}
		}else {
			ans = (B-A)*E;
		}
		
		System.out.println(ans);
		
	}
}