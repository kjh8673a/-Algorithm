import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] pi;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] T = br.readLine().toCharArray();
		char[] P = br.readLine().toCharArray();

		pi = makeTable(P);
		doKMP(T, P);
	}

	public static int[] makeTable(char[] pattern) {
		int n = pattern.length;
		int[] table = new int[n];

		int idx = 0;
		for (int i = 1; i < n; i++) {
			while (idx > 0 && pattern[i] != pattern[idx]) {
				idx = table[idx - 1];
			}
			if (pattern[i] == pattern[idx]) {
				table[i] = ++idx;
			}
		}
		return table;
	}

	public static void doKMP(char[] str, char[] pattern) {
		int n = str.length;
		int m = pattern.length;

		int idx = 0;
		int ans = 0;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			while (idx > 0 && str[i] != pattern[idx]) {
				idx = pi[idx - 1];
			}
			if (str[i] == pattern[idx]) {
				if (idx == m - 1) {
					ans++;
					sb.append(i - idx + 1 + " ");
					idx = pi[idx];
				} else {
					idx++;
				}
			}
		}

		sb.insert(0, ans + "\n");
		System.out.println(sb.toString());
	}

}