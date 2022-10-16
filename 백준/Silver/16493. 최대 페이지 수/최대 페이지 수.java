import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int day;
		int page;

		public Node(int day, int page) {
			this.day = day;
			this.page = page;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Node[] list = new Node[M + 1];
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			int page = Integer.parseInt(st.nextToken());

			list[i] = new Node(day, page);
		}

		int[][] dp = new int[M + 1][N + 1];

		for(int i = 1; i < M + 1; i++) {
			int cost = list[i].day;
			int value = list[i].page;
			for(int j = 0; j < N + 1; j++) {
				if(cost <= j) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost] + value);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}

		System.out.println(dp[M][N]);

	}

}