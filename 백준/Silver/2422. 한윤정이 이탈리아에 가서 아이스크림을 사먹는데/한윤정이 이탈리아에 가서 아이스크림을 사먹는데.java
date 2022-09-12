import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visit;
	static int cnt, n, m;
	static int[][] combi;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		combi = new int[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			combi[a][b] = 1;
			combi[b][a] = 1;
		}

		cnt = 0;
		for (int i = 1; i < n + 1 - 2; i++) {
			solve(i,0, 0);
		}

		System.out.println(cnt);

	}

	public static void solve(int num, int num2, int num3) {
		if (num3 != 0) {
			cnt++;
			return;
		}

		if(num2 == 0) {
			for (int i = num + 1; i < n + 1; i++) {
				if (combi[num][i] != 1) {
					solve(num, i, 0);
				}
			}
		}else {
			for(int i = num2 + 1; i < n + 1; i++) {
				if(combi[num][i] != 1 && combi[num2][i] != 1) {
					solve(num, num2, i);
				}
			}
		}
		
	}

}
