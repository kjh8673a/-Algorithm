import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		String ans = "";

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch - 0 >= 97) {
				ans += String.valueOf(ch).toUpperCase();
			} else {
				ans += String.valueOf(ch).toLowerCase();
			}

		}

		System.out.println(ans);
	}

}