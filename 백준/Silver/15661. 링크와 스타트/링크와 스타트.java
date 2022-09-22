import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] board;
	static int ans;
	static boolean[] teamA;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		board = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = Integer.MAX_VALUE;

		// 팀A에 선택되면 true로 바꾼다
		teamA = new boolean[n];

		makeTeam(0, 0);

		System.out.println(ans);

	}

	public static void makeTeam(int idx, int cnt) {
		if (idx == n) {
			// 팀A가 0명이거나 N명이면 계산하지 않는다
			if(cnt != 0 && cnt != n) {
				int scoreA = 0;
				int scoreB = 0;

				for(int i = 0; i < n; i++) {
					if(teamA[i]) {
						for(int j = 0; j < n; j++) {
							if(teamA[j]) {
								scoreA += board[i][j];
							}
						}
					}else {
						for(int j = 0; j < n; j++) {
							if(!teamA[j]) {
								scoreB += board[i][j];
							}
						}
					}
				}

				ans = Math.min(ans, Math.abs(scoreA - scoreB));
			}
			return;
		}

		// idx번 선수 팀A에 넣고 다음 번호 선수로 넘어간다
		teamA[idx] = true;
		makeTeam(idx + 1, cnt + 1);
		// 팀A에 넣었던 것 없던일로 하고 다음 번호 선수로 넘어간다
		teamA[idx] = false;
		makeTeam(idx + 1, cnt);
	}

}