import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static int ans;
	static int day;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ans = 0;
		day = 13;
		for (int i = 2019; i <= N; i++) {
			doLunar(i);
			for (int j = 0; j < 12; j++) {
				doFriday(day, j);
			}
		}
		System.out.println(ans);
	}

	public static void doLunar(int y) {
		if (y % 400 == 0) {
			month[1] = 29;
		} else if (y % 100 == 0) {
			month[1] = 28;
		} else if (y % 4 == 0) {
			month[1] = 29;
		} else {
			month[1] = 28;
		}
	}

	public static void doFriday(int d, int m) {
		if (d % 7 == 4) {
			ans++;
		}
		day += month[m];
	}

}