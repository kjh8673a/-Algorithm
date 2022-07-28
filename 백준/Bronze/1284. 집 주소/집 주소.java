import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = { 4, 2, 3, 3, 3, 3, 3, 3, 3, 3 };

		while (true) {
			String n = sc.next();

			if (n.equals("0"))
				break;

			int ans = 0;

			ans += 2;

			for (int i = 0; i < n.length(); i++) {
				for (int j = 0; j < arr.length; j++) {
					if (n.charAt(i) - '0' == j) {
						ans += arr[j];
					}
				}
			}

			ans += n.length() - 1;

			System.out.println(ans);

		}

		sc.close();
	}
}