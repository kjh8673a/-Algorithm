import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		String num = st.nextToken();
		int b = Integer.parseInt(st.nextToken());

		int len = num.length() - 1;

		long ans = 0;
		for (int i = 0; i < num.length(); i++) {
			char ch = num.charAt(i);
			int now;
			
			if (ch - 0 >= 65) {
				now = ch - 55;
			} else {
				now = ch - 48;
			}

			ans += now * Math.pow(b, len);
			len--;
		}

		System.out.println(ans);

	}

}