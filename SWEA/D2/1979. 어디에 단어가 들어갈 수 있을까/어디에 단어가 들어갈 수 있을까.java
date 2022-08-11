import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for(int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int K = sc.nextInt();

			int[][] puzzle = new int[N][N];
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					puzzle[j][k] = sc.nextInt();
				}
			}

			int ans = 0;

			// 가로방향
			for(int j = 0; j < N; j++) {
				int cnt = 0;
				for(int k = 0; k < N; k++) {
					if(puzzle[j][k] == 1) {
						cnt++;
						if(k == N-1 && cnt == K) {
							ans++;
						}
					}else {
						if(cnt == K) {
							ans++;
						}
						cnt = 0;
					}
				}
			}

			// 세로방향
			for(int j = 0; j < N; j++) {
				int cnt = 0;
				for(int k = 0; k < N; k++) {
					if(puzzle[k][j] == 1) {
						cnt++;
						if(k == N-1 && cnt == K) {
							ans++;
						}
					}else {
						if(cnt == K) {
							ans++;
						}
						cnt = 0;
					}
				}
			}

			System.out.println("#" + (i+1) + " " + ans);
			
		}

		sc.close();

	}

}