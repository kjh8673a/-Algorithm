import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] rope = new int[n];
		for(int i = 0; i < n; i++) {
			rope[i] = sc.nextInt();
		}

		Arrays.sort(rope);

		int max = Integer.MIN_VALUE;
		for(int i = rope.length-1; i >= 0; i--) {
			int wei = 0;
			int cnt = 0;
			for(int j = 0; j < rope.length-i; j++) {
				cnt++;
			}
			wei = rope[i] * cnt;
			max = Math.max(max, wei);
		}

		System.out.println(max);

		sc.close();

	}
}