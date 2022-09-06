import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m, cnt;
	static boolean[][] con;
	static boolean[] virus;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		m = Integer.parseInt(br.readLine());

		con = new boolean[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			con[a][b] = true;
			con[b][a] = true;
		}

		virus = new boolean[n + 1];

		cnt = 0;

		virus(1);

		

		System.out.println(cnt - 1);

	}

	public static void virus(int num) {

		virus[num] = true;
		cnt++;
		
		for (int i = 1; i < n + 1; i++) {
			if (!virus[i] && con[num][i]) {
				virus(i);
			}
		}
	}

}