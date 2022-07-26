import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int ans = 0;
		for(int i = 1; i <= n; i++) {
			int tmp = i;
			int num = 0;
			while(tmp > 0) {
				num += tmp%10;
				tmp = tmp/10;
			}
			if(i % num == 0) {
				ans++;
			}
		}
		System.out.println(ans);
		sc.close();
	}
}