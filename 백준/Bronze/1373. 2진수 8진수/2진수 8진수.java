import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

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
			// 문자열의 길이를 3의 배수로 만들어서 앞에서부터 3자리씩 읽는다
			int len = num.length();
			if(len % 3 == 1) {
				num = "00" + num;
			}else if(len % 3 == 2) {
				num = "0" + num;
			}

			Map<String, String> map = new HashMap<>() {
				{
					put("000", "0");
					put("001", "1");
					put("010", "2");
					put("011", "3");
					put("100", "4");
					put("101", "5");
					put("110", "6");
					put("111", "7");
				}
			};

			for (int i = 0; i < num.length(); i+=3) {
				sb.append(map.get(num.substring(i, i+3)));
			}
		}

		System.out.println(sb.toString());
	}

}