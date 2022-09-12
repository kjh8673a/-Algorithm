import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int a, t, guho;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		a = Integer.parseInt(br.readLine());
		t = Integer.parseInt(br.readLine());
		guho = Integer.parseInt(br.readLine());

		System.out.println(bbundegi());

	}

	public static int bbundegi() {
		int bbun = 0;
		int degi = 0;
		int cnt = 2;

		while (true) {

			for (int i = 0; i < 4; i++) {
				if (i % 2 == 0) {
					bbun++;
				} else {
					degi++;
				}

				if (bbun == t && guho == 0) {
					return (bbun + degi - 1) % a;
				}

				if (degi == t && guho == 1) {
					return (bbun + degi - 1) % a;
				}

			}

			for (int i = 0; i < cnt; i++) {
				bbun++;
				if (bbun == t && guho == 0) {
					return (bbun + degi - 1) % a;
				}
			}

			for (int i = 0; i < cnt; i++) {
				degi++;
				if (degi == t && guho == 1) {
					return (bbun + degi - 1) % a;
				}
			}

			cnt++;
		}
	}

}
