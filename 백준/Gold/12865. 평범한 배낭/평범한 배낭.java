import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int weight, value;

		public Node(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		// 물품의 수
		int n = Integer.parseInt(st.nextToken());
		// 버틸 수 있는 무게
		int k = Integer.parseInt(st.nextToken());

		Node[] list = new Node[n + 1];

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[i] = new Node(w, v);
		}

		int[][] dp = new int[n + 1][k + 1];

		for (int i = 1; i < n + 1; i++) {
			// 물건별로 모든 무게에 대해 최적해를 구한다
			int weight = list[i].weight;
			int value = list[i].value;
			for (int j = 0; j < k + 1; j++) {
				if (weight <= j) {
					// j에 대해 이전에 구한 최적해 VS
                    // 현재 물건을 넣기 전 최적해 + 현재 물건 가치
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight] + value);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		System.out.println(dp[n][k]);

	}

}
