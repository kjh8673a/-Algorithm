import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		if (s < 1024) {
			System.out.println("No thanks");
		} else {
			String need = Integer.toBinaryString(s-1023);
			String borrow = Integer.toBinaryString((s - 1023) & m);

			if(need.equals(borrow)) {
				System.out.println("Thanks");
			}else {
				System.out.println("Impossible");
			}
		}

	}

}