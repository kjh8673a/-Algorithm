import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for(int i = n; i > 0; i--) {
			int tmp = i;
			while(tmp > 0) {
				if(tmp % 10 != 4 && tmp % 10 != 7) {
					break;
				}else {
					tmp /= 10;
				}
			}
			if(tmp == 0) {
				System.out.println(i);
				break;
			}
		}

		sc.close();

	}
}
