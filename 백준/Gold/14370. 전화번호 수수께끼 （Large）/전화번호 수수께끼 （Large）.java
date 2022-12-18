import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); // 테스트케이스의 개수

		for (int tc = 1; tc <= T; tc++) {
			String S = br.readLine();
			// ZERO -> Z
			// ONE
			// TWO -> W
			// THREE
			// FOUR -> U
			// FIVE
			// SIX -> X
			// SEVEN
			// EIGHT -> G
			// NINE
			int[] alpha = new int[26]; // 각 알파벳이 몇개씩 있는지 넣을 배열
			for (int i = 0; i < S.length(); i++) {
				alpha[S.charAt(i) - 'A']++;
			}

			int[] num = new int[10]; // 각 숫자가 몇개씩 들어있는지 넣을 배열
			// (Z)ERO / ONE / T(W)O / THREE / FO(U)R / FIVE / SI(X) / SEVEN / EI(G)HT / NINE
			if (alpha['Z' - 'A'] != 0) {
				int cnt = alpha['Z' - 'A'];
				num[0] += cnt;
				alpha['Z' - 'A'] -= cnt;
				alpha['E' - 'A'] -= cnt;
				alpha['R' - 'A'] -= cnt;
				alpha['O' - 'A'] -= cnt;
			}
			if (alpha['W' - 'A'] != 0) {
				int cnt = alpha['W' - 'A'];
				num[2] += cnt;
				alpha['T' - 'A'] -= cnt;
				alpha['W' - 'A'] -= cnt;
				alpha['O' - 'A'] -= cnt;
			}
			if (alpha['U' - 'A'] != 0) {
				int cnt = alpha['U' - 'A'];
				num[4] += cnt;
				alpha['F' - 'A'] -= cnt;
				alpha['O' - 'A'] -= cnt;
				alpha['U' - 'A'] -= cnt;
				alpha['R' - 'A'] -= cnt;
			}
			if (alpha['X' - 'A'] != 0) {
				int cnt = alpha['X' - 'A'];
				num[6] += cnt;
				alpha['S' - 'A'] -= cnt;
				alpha['I' - 'A'] -= cnt;
				alpha['X' - 'A'] -= cnt;
			}
			if (alpha['G' - 'A'] != 0) {
				int cnt = alpha['G' - 'A'];
				num[8] += cnt;
				alpha['E' - 'A'] -= cnt;
				alpha['I' - 'A'] -= cnt;
				alpha['G' - 'A'] -= cnt;
				alpha['H' - 'A'] -= cnt;
				alpha['T' - 'A'] -= cnt;
			}
			// (O)NE / T(H)REE / (F)IVE / (S)EVEN / NINE
			if (alpha['O' - 'A'] != 0) {
				int cnt = alpha['O' - 'A'];
				num[1] += cnt;
				alpha['O' - 'A'] -= cnt;
				alpha['N' - 'A'] -= cnt;
				alpha['E' - 'A'] -= cnt;
			}
			if (alpha['H' - 'A'] != 0) {
				int cnt = alpha['H' - 'A'];
				num[3] += cnt;
				alpha['T' - 'A'] -= cnt;
				alpha['H' - 'A'] -= cnt;
				alpha['R' - 'A'] -= cnt;
				alpha['E' - 'A'] -= cnt;
				alpha['E' - 'A'] -= cnt;
			}
			if (alpha['F' - 'A'] != 0) {
				int cnt = alpha['F' - 'A'];
				num[5] += cnt;
				alpha['F' - 'A'] -= cnt;
				alpha['I' - 'A'] -= cnt;
				alpha['V' - 'A'] -= cnt;
				alpha['E' - 'A'] -= cnt;
			}
			if (alpha['S' - 'A'] != 0) {
				int cnt = alpha['S' - 'A'];
				num[7] += cnt;
				alpha['S' - 'A'] -= cnt;
				alpha['E' - 'A'] -= cnt;
				alpha['V' - 'A'] -= cnt;
				alpha['E' - 'A'] -= cnt;
				alpha['N' - 'A'] -= cnt;
			}
			// N(I)NE
			if (alpha['I' - 'A'] != 0) {
				int cnt = alpha['I' - 'A'];
				num[9] += cnt;
				alpha['N' - 'A'] -= cnt;
				alpha['I' - 'A'] -= cnt;
				alpha['N' - 'A'] -= cnt;
				alpha['E' - 'A'] -= cnt;
			}

			// num배열에 있는 개수만큼 해당 숫자 출력
			sb.append("Case #" + tc + ": ");
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < num[i]; j++) {
					sb.append(i);
				}
			}
			sb.append("\n");

		}

		System.out.println(sb.toString());

	}
}