import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, min;
	static int[][] ingredient;
	static int[] pick;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 재료의 개수
		n = Integer.parseInt(br.readLine());

		// 재료를 담을 배열 [n][0]=신맛, [n][1]=쓴맛
		ingredient = new int[n][2];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ingredient[i][0] = Integer.parseInt(st.nextToken());
			ingredient[i][1] = Integer.parseInt(st.nextToken());
		}

		// 선택한 재료를 담을 베열
		pick = new int[n];
		// 신맛, 쓴맛 차이의 최솟값
		min = Integer.MAX_VALUE;

		cook(0, 0, 0);

		System.out.println(min);
	}

	public static void cook(int idx, int pidx, int size) {
		if(idx == n) {
			// 재료를 한 개도 안골랐으면 계산하지 않음
			if(size == 0) {
				return;
			}

			// 신맛의 곱, 쓴맛의 합
			int sourSum = 1;
			int bitterSum = 0;
			for(int i = 0; i < size; i++) {
				sourSum *= ingredient[pick[i]][0];
				bitterSum += ingredient[pick[i]][1];
			}

			min = Math.min(min, Math.abs(sourSum - bitterSum));

			return;
		}

		pick[pidx] = idx;
		cook(idx+1, pidx+1, size+1);
		cook(idx+1, pidx, size);

	}

}