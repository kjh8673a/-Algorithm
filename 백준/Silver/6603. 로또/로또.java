import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int k;
	static int[] numbers;
	static boolean[] sel;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());

			if (k == 0) {
				break;
			}

			sel = new boolean[k];
			numbers = new int[k];
			for (int i = 0; i < k; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}

			comb(0, 0);

			sb.append("\n");
		}

		System.out.println(sb.toString());
		
	}

	public static void comb(int idx, int cnt) {
		if (cnt == 6) {
			for(int i = 0; i < k; i++) {
				if(sel[i]) {
					sb.append(numbers[i]).append(" ");
				}
			}
			sb.append("\n");
			return;
		}

		if (idx == k) {
			return;
		}

		sel[idx] = true;
		comb(idx + 1, cnt + 1);
		sel[idx] = false;
		comb(idx + 1, cnt);

	}
}