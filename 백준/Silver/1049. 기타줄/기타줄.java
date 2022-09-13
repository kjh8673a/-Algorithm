import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 끊어진 기타줄의 개수 n, 브랜드 개수 m
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 패키지 가격, 낱개 가격 중 최솟값만 저장한다
		int minPackage = Integer.MAX_VALUE;
		int minEach = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			minPackage = Math.min(minPackage, Integer.parseInt(st.nextToken()));
			minEach = Math.min(minEach, Integer.parseInt(st.nextToken()));
		}

		// 패키지가격이 낱개*6보다 작으면 패키지를 선택한다
		// 필요한 개수가 6개보다 작을때는 낱개*n과 비교한다
		int ans = 0;
		while (n > 0) {
			if (n >= 6) {
				if (minPackage < minEach * 6) {
					ans += minPackage;
				} else {
					ans += minEach * 6;
				}
			} else {
				if (minPackage < minEach * n) {
					ans += minPackage;
				} else {
					ans += minEach * n;
				}
			}
			n -= 6;
		}

		System.out.println(ans);

	}

}