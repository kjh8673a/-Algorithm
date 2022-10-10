import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] numbers, result;
	static boolean[] visit;
	static HashSet<String> ans;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		numbers = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);

		result = new int[m];
		visit = new boolean[n];
		ans = new HashSet<>();
		find(0);

		System.out.println(sb);

	}

	public static void find(int cnt) {
		if (cnt > m) {
			return;
		}

		if (cnt == m) {
			String tmp = "";
			for (int i = 0; i < m; i++) {
				tmp += result[i] + " ";
			}
			if(!ans.contains(tmp)) {
				sb.append(tmp).append("\n");
				ans.add(tmp);
			}
			return;
		}

		for (int i = 0; i < n; i++) {
			if(!visit[i]) {
				visit[i] = true;
				result[cnt] = numbers[i];
				find(cnt + 1);
				visit[i] = false;
			}			
		}
	}


}