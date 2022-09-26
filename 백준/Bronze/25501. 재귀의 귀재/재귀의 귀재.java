import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			String str = br.readLine();
			cnt = 0;
			int ans = isPalindrome(str, 0, str.length() - 1);

			sb.append(ans + " " + cnt).append("\n");
		}

		System.out.println(sb.toString());

	}

	public static int isPalindrome(String s, int l, int r) {
		cnt++;
		
		if (l >= r) {
			return 1;
		} else if (s.charAt(l) != s.charAt(r)) {
			return 0;
		} else {
			return isPalindrome(s, l + 1, r - 1);
		}

	}

}