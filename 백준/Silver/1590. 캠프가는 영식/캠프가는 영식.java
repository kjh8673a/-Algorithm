import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int t = sc.nextInt();

		int time = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			int s = sc.nextInt();
			int l = sc.nextInt();
			int c = sc.nextInt();

			if(t <= s) {
				time = Math.min(time, s-t);
			}else {
				for(int j = 0; j < c; j++) {
					if(s + l * j >= t) {
						time = Math.min(time, s + l * j - t);
						break;
					}
				}
			}
		}
		if(time == Integer.MAX_VALUE) {
			time = -1;
		}

		System.out.println(time);

		sc.close();

	}

}