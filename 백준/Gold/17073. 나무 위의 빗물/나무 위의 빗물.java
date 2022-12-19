import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 노드의 수
		int W = Integer.parseInt(st.nextToken()); // 물의 양

		// 최하단 노드까지 물이 내려간다
		// 물의 양을 최하단 노드의 개수로 나누자

		int[] indegree = new int[N + 1]; // 각 노드에 연결된 선의 개수
		int cnt = 0; // 연결된 선의 개수가 1이면 최하단 노드
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			indegree[U]++;
			if (indegree[U] == 1) {
				cnt++;
			} else if (indegree[U] == 2) {
				cnt--;
			}
			indegree[V]++;
			if (indegree[V] == 1) {
				cnt++;
			} else if (indegree[V] == 2) {
				cnt--;
			}
		}

		if (indegree[1] == 1) { // 루트 노드가 연결된 선이 1개일 경우
			cnt--;
		}

		System.out.println((double) W / cnt);

	}
}