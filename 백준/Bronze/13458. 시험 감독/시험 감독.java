import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 시험장의 개수
		int N = Integer.parseInt(br.readLine());

		// 응시자의 수
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		// 총감독관이 감시할 수 있는 응시자의 수
		int B = Integer.parseInt(st.nextToken());
		// 부감독관이 감시할 수 있는 응시자의 수
		int C = Integer.parseInt(st.nextToken());

		long ans = 0;
		// 반복을 돌며 시험장 별로 몇명 필요한지 체크
		for (int i = 0; i < N; i++) {
			// 일단 총감독관 한명 배치하고 시작
			ans++;

			// 총감독관이 감시할 수 있는 수보다 더 많다면
			// 부감독관이 몇 명 더 필요한지 체크
			if (arr[i] - B > 0) {
				ans += (arr[i] - B) / C;
				if ((arr[i] - B) % C > 0) {
					ans++;
				}
			}
		}

		System.out.println(ans);

	}
}