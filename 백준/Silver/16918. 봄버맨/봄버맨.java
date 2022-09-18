import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r, c, n;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static int[][] board;
	static String[][] ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		board = new int[r][c];

		// 빈칸은 -1로 놓고
		// 처음 놓는 폭탄은 2로 시작해서 0이 되면 터트린다 (시작은 1초)
		for(int i = 0; i < r; i++) {
			String str = br.readLine();
			for(int j = 0; j < c; j++) {
				if(str.charAt(j) == 'O') {
					board[i][j] = 2;
				}else {
					board[i][j] = -1;
				}
			}
		}

		doBomber(1);

		ans = new String[r][c];
		resetBoard();

		for(int i = 0 ; i < r; i++) {
			for(int j = 0; j < c; j++) {
				System.out.print(ans[i][j]);
			}
			System.out.println();
		}

	}

	private static void resetBoard() {
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(board[i][j] == -1) {
					ans[i][j] = ".";
				}else {
					ans[i][j] = "O";
				}
			}
		}

	}

	public static void doBomber(int time) {
		// 땅이 비어있으면(-1이면) 폭탄(3)을 넣어주고
		// 폭탄이 있으면 -1씩 해준다
		// 0이되면 폭탄을 터트리고 폭탄 주위까지 -1로 만든다
		// time+1해서 다시 재귀
		if(time == n) {
			return;
		}

		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(board[i][j] == -1) {
					board[i][j] = 3;
				}else {
					board[i][j]--;
				}
			}
		}

		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(board[i][j] == 0) {
					board[i][j] = -1;
					for(int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];

						if(nr >= 0 && nc >= 0 && nr < r && nc < c) {
							if(board[nr][nc] != 0) {
								board[nr][nc] = -1;
							}
						}
					}
				}
			}
		}

		doBomber(time + 1);

	}
}