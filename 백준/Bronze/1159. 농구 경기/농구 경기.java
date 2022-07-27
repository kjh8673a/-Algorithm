import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = String.valueOf(sc.next().charAt(0));
		}
		Arrays.sort(arr);
		
		String check = arr[0];
		int cnt = 0;
		String ans = "";
		for (int i = 0; i < n; i++) {
			if (!arr[i].equals(check)) {
				if (cnt >= 5) {
					ans += check;
				}
				check = arr[i];
				cnt = 1;
			} else {
				cnt++;
			}
			if(i == n-1 && cnt >= 5) {
				ans += check;
			}
		}
		
		if(ans.length() != 0) {
			System.out.println(ans);
		}else {
			System.out.println("PREDAJA");
		}
		
		sc.close();
	}
}