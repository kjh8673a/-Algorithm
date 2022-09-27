import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, min;
	static int[][] board;
	static boolean[] visit;
	static int[] groupA, groupB;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		board = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visit = new boolean[n];

		groupA = new int[n / 2];
		groupB = new int[n / 2];

		min = Integer.MAX_VALUE;

		solve(0, 0, 0);

		System.out.println(min);

	}

	public static void solve(int idx, int aidx, int pick) {
		// 남은사람 다 더해도 한 팀이 안꾸려지면 끝
		if(pick + (n - idx) < n / 2) {
			return;
		}

		// 한쪽 팀을 다 구성했으면 계산
		if (pick == n / 2) {
			int bidx = 0;
			for (int i = 0; i < n; i++) {
				if (!visit[i]) {
					groupB[bidx++] = i;
				}
			}

			min = Math.min(min, sinergy());
			return;
		}

		visit[idx] = true;
		groupA[aidx] = idx;
		solve(idx + 1, aidx + 1, pick + 1);

		visit[idx] = false;
		solve(idx + 1, aidx, pick);

	}

	public static int sinergy() {
		int aSum = 0;
		int bSum = 0;

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < n / 2; j++) {
				if (i != j) {
					aSum += board[groupA[i]][groupA[j]];
					bSum += board[groupB[i]][groupB[j]];
				}
			}
		}

		return Math.abs(aSum - bSum);
	}

}