import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(br.readLine());

		// a진법으로 나타낸 숫자를 10진법으로 바꿔 num에 더해준다
		int num = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = m - 1; i >= 0; i--) {
			num += (int) (Integer.parseInt(st.nextToken()) * Math.pow(a, i));
		}

		// b진법으로 바꿀때 b의 몇제곱부터 나타내야되는지 계산한다
		int len = 0;
		while (Math.pow(b, len) <= num) {
			len++;
		}

		// b의 len-1제곱부터 시작해서
		// num을 b의 i제곱으로 나눈 몫을 출력한다
		for (int i = len - 1; i >= 0; i--) {
			sb.append((int) (num / Math.pow(b, i))).append(" ");
			num = (int) (num % Math.pow(b, i));
		}

		System.out.println(sb.toString());
	}

}