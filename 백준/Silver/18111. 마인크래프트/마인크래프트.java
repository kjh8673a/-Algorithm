import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int[][] field = new int[n][m];

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, field[i][j]);
				min = Math.min(min, field[i][j]);
			}
		}

		int time = Integer.MAX_VALUE;
		int height = 0;

		for (int i = min; i <= max; i++) {
			int block = b;
			int now = 0;

			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (field[j][k] > i) {
						now += (field[j][k] - i) * 2;
						block += field[j][k] - i;
					} else if (field[j][k] < i) {
						now += i - field[j][k];
						block -= i - field[j][k];
					}
				}
			}

			if(block < 0) {
				break;
			}

			time = Math.min(time, now);
			if(time == now) {
				height = i;
			}
		}

		System.out.println(time + " " + height);

	}

}