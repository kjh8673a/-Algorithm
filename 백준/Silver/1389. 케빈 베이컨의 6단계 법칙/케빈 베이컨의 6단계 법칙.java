import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 플로이드-워셜 알고리즘
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		// 정점의 개수
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] dist = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j) {
					dist[i][j] = 0; // 자기 자신은 0
				} else {
					dist[i][j] = 100000000; // 매우 큰 값
				}
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			// 서로 연결되어 있으면 가중치 1로 표시
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;

			dist[a][b] = 1;
			dist[b][a] = 1;
		}

		// 플로이드-워셜 알고리즘
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					// 기존 i~j까지의 거리와, k번째 노드를 거쳐가는 거리를 비교해 최단거리 갱신
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		int min = 100000000;
		int idx = -1;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				sum += dist[i][j];
			}
			if (min > sum) {
				min = sum;
				idx = i;
			}
		}

		int ans = idx + 1;

		System.out.println(ans);

	}

}