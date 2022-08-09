import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int cnt = 1;
		if(n == 0) cnt = 0;
		int sum = 0;
		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();
			if(sum + a <= m) {
				sum += a;
			}else {
				cnt++;
				sum = a;
			}
		}

		System.out.println(cnt);

		sc.close();

	}
}