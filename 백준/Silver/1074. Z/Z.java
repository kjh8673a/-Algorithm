import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, r, c;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int len = (int) Math.pow(2, n);

		int ans = recur(0, 0, len);
		
		System.out.println(ans);
	}

	public static int recur(int nr, int nc, int size) {
		if(size == 1) {
			return 0;
		}

		int reSize = size / 2;
		int reStart = (int)Math.pow(reSize, 2);

		if(r < nr + reSize && c < nc + reSize) {
			return recur(nr, nc, reSize);
		}

		else if(r < nr + reSize && c >= nc + reSize) {
			return recur(nr, nc + reSize, reSize) + reStart;
		}

		else if(r >= nr + reSize && c < nc + reSize) {
			return recur(nr + reSize, nc, reSize) + reStart * 2;
		}

		else {
			return recur(nr + reSize, nc + reSize, reSize) + reStart * 3;
		}
	}
}