import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 내려가기 - DP
	 * 인접한 칸으로만 내려갈수있다(대각선까지)
	 * 최대, 최소 구하기
	 * DP배열이 2개 있어야 할듯
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] dpMax = new int[n][3];
		int[][] dpMin = new int[n][3];

		StringTokenizer st = new StringTokenizer(br.readLine());
		dpMax[0][0] = dpMin[0][0] = Integer.parseInt(st.nextToken());
		dpMax[0][1] = dpMin[0][1] = Integer.parseInt(st.nextToken());
		dpMax[0][2] = dpMin[0][2] = Integer.parseInt(st.nextToken());

		for(int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			// 윗 줄 0번 1번에서 내려올 수 있다
			dpMax[i][0] = Math.max(dpMax[i-1][0], dpMax[i-1][1]) + a;
			dpMin[i][0] = Math.min(dpMin[i-1][0], dpMin[i-1][1]) + a;
			// 윗 줄에서 0번 1번 2번에서 내려올 수 있다
			dpMax[i][1] = Math.max(Math.max(dpMax[i-1][0], dpMax[i-1][1]), dpMax[i-1][2]) + b;
			dpMin[i][1] = Math.min(Math.min(dpMin[i-1][0], dpMin[i-1][1]), dpMin[i-1][2]) + b;
			// 윗 줄에서 1번 2번에서 내려올 수 있다
			dpMax[i][2] = Math.max(dpMax[i-1][1], dpMax[i-1][2]) + c;
			dpMin[i][2] = Math.min(dpMin[i-1][1], dpMin[i-1][2]) + c;
		}

		int ansMax = Math.max(Math.max(dpMax[n-1][0], dpMax[n-1][1]), dpMax[n-1][2]);
		int ansMin = Math.min(Math.min(dpMin[n-1][0], dpMin[n-1][1]), dpMin[n-1][2]);

		System.out.println(ansMax + " " + ansMin);

	}

}