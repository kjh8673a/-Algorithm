import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		// AC^2 = a^2 - b^2
		// BD^2 = a^2 - c^2

		int ans = -1;
		for (int i = 1; i < 101; i++) {
			if ((b * c + i * a) * (b * c + i * a) == (a * a - b * b) * (a * a - c * c)) {
				ans = i;
				break;
			}
		}
		System.out.println(ans);

	}

}