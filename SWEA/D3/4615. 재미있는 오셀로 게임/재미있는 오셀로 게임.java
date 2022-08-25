import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] board;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for(int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
	
			board = new int[n][n];
	
			for (int i = n / 2 - 1; i <= n / 2; i++) {
				for (int j = n / 2 - 1; j <= n / 2; j++) {
					if ((i + j) % 2 == 0) {
						board[i][j] = 2;
					} else {
						board[i][j] = 1;
					}
				}
			}
	
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int color = Integer.parseInt(st.nextToken());
	
				board[b - 1][a - 1] = color;
	
				check(b-1, a-1, color);
			}
	
			sb.append("#" + tc + " ");

			int cntBalck = 0;	
			int cntWhite = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(board[i][j] == 1) cntBalck++;
					if(board[i][j] == 2) cntWhite++;
				}
			}

			sb.append(cntBalck + " " + cntWhite).append("\n");
		}

		System.out.println(sb.toString());
		
	}

	public static void check(int a, int b, int color) {
		
		int[] dr = {1, 1, -1, -1, 1, -1, 0, 0};
		int[] dc = {1, -1, 1, -1, 0, 0, 1, -1};

		for(int i = 0; i < 8; i++) {
			int x = a + dr[i];
			int y = b + dc[i];
			
			if(x < 0 || y < 0 || x >= n || y >= n) {
				continue;
			}

			boolean[][] change = new boolean[n][n];
			boolean ischange = false;
			while(board[x][y] + color == 3) {
				change[x][y] = true;
				x += dr[i];
				y += dc[i];				
				
				if(x < 0 || y < 0 || x >= n || y >= n) {
					break;
				}

				if(board[x][y] == color) {
					ischange = true;
					break;
				}
			}

			if(ischange) {
				x = a + dr[i];
				y = b + dc[i];
				while(change[x][y]) {
					board[x][y] = color;
					x += dr[i];
					y += dc[i];	
				}
			}

		}
				
	}
}