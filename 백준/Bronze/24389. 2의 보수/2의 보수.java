import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());

		int boNum = ~num + 1;

		String XOR = Integer.toBinaryString(num ^ boNum);

		int cnt = 0;
		for(int i = 0; i < 32; i++) {
			if(XOR.charAt(i) == '1') {
				cnt++;
			}
		}

		System.out.println(cnt);
	}

}