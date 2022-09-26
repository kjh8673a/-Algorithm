import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n, ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		while(t-- > 0) {
			n = Integer.parseInt(br.readLine());
			ans = 0;
			makeNum(0);

			sb.append(ans).append("\n");
		}

		System.out.println(sb.toString());
	}

	public static void makeNum(int num) {
		if(num > n) {
			return;
		}
		
		if(num == n) {
			ans++;
			return;
		}

		makeNum(num + 1);
		makeNum(num + 2);
		makeNum(num + 3);
	}

}