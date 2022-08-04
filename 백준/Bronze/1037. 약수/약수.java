import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		if (n == 1) {
			System.out.println((long)(Math.pow(arr[0], 2)));
		} else {
			Arrays.sort(arr);
			System.out.println((long) (arr[0] * arr[n - 1]));
		}

		sc.close();

	}
}
