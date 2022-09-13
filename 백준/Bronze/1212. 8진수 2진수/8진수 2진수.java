import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String num = br.readLine();

		if (num.equals("0")) {
			sb.append(0);
		} else {
			// 8은 2의 세제곱이다
			// 8진수 한자리는 2진수 3자리를 차지한다
			// 0~7까지 올 수 있으므로 3자리로 바꿔서 ans에 더한다
			String[] arr = { "000", "001", "010", "011", "100", "101", "110", "111" };

			for (int i = 0; i < num.length(); i++) {
				int now = num.charAt(i) - '0';
				if (i == 0) {
					// ans는 0으로 시작하면 안된다
					String ans = arr[now];
					while (ans.startsWith("0")) {
						ans = ans.substring(1);
					}
					sb.append(ans);
				} else {
					sb.append(arr[now]);
				}
			}
		}

		System.out.println(sb.toString());
	}

}