import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char[][] dna = new char[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				dna[i][j] = str.charAt(j);
			}
		}

		String ans = "";
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			Map<Character, Integer> map = new HashMap<>();

			for (int j = 0; j < n; j++) {
				map.put(dna[j][i], map.getOrDefault(dna[j][i], 0) + 1);
			}

			int max = Integer.MIN_VALUE;
			char now = ' ';
			for (char nKey : map.keySet()) {
				if (max < map.get(nKey)) {
					now = nKey;
				}
				if (max == map.get(nKey) && nKey - 0 < now - 0) {
					now = nKey;
				}
				max = Math.max(map.get(nKey), max);
			}
			ans += now;
			cnt += n - map.get(now);
		}

		System.out.println(ans);
		System.out.println(cnt);

	}

}
