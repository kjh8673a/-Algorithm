import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int ans = 0;
		if (N == 1) {
			ans = 1;
		} else if (N == 2) {
			if (M < 3) {
				ans = 1;
			} else if (M < 5) {
				ans = 2;
			} else if (M < 7) {
				ans = 3;
			} else {
				ans = 4;
			}
		} else if (N >= 3) {
			if (M == 1) {
				ans = 1;
			} else if (M == 2) {
				ans = 2;
			} else if (M == 3) {
				ans = 3;
			} else if (M < 7) {
				ans = 4;
			} else {
				ans = M - 2;
			}
		}

		System.out.println(ans);
	}
}