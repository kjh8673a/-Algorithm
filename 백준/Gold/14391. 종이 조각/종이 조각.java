import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int ans;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			String num = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = num.charAt(j) - '0';
			}
		}

		ans = 0;

		solve(0, n, 0, m, 0);

		System.out.println(ans);

	}

	public static void solve(int top, int down, int left, int right, int sum) {
		if (top == down || left == right) {
			ans = Math.max(ans, sum);
			return;
		}

		// 가로로 절단
		if (top != down) {
			// 가로로 잘랐을때 맨 위에 것
			int tlr = 0;
			// 가로로 잘랐을때 맨 밑에 것
			int dlr = 0;

			for (int i = left; i < right; i++) {
				tlr = tlr * 10 + arr[top][i];
			}
			for (int i = left; i < right; i++) {
				dlr = dlr * 10 + arr[down - 1][i];
			}

			// top+1해서 맨 윗줄 없애기
			solve(top + 1, down, left, right, sum + tlr);
			// down-1해서 맨 아랫줄 없애기
			solve(top, down - 1, left, right, sum + dlr);
		}

		// 세로로 절단
		if (left != right) {
			// 세로로 잘랐을때 맨 왼쪽 것
			int tld = 0;
			// 세로로 잘랐을때 맨 오른쪽 것
			int trd = 0;

			for (int i = top; i < down; i++) {
				tld = tld * 10 + arr[i][left];
			}
			for (int i = top; i < down; i++) {
				trd = trd * 10 + arr[i][right - 1];
			}

			// left+1해서 맨 왼쪽 줄 없애기
			solve(top, down, left + 1, right, sum + tld);
			// right-1해서 맨 오른쪽 줄 없애기
			solve(top, down, left, right - 1, sum + trd);
		}

	}

}