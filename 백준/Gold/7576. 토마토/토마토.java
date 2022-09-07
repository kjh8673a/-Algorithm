import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int m, n, changed, date;
	static int[][] board;
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		board = new int[n][m];

		int zeroCnt = 0;
		Queue<int[]> que = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 1) {
					que.add(new int[] {i, j});
				}
				if (board[i][j] == 0) {
					zeroCnt++;
				}
			}
		}

		if (zeroCnt == 0) {
			System.out.println(0);
		} else {
			changed = 0;
			date = 0;

			tomato(que, 0, 0);

			if (changed != zeroCnt) {
				System.out.println(-1);
			} else {
				System.out.println(date);
			}
		}

	}

	public static void tomato(Queue<int[]> que, int cnt, int day) {
		changed = cnt;
		date = day;

		Queue<int[]> nQue = new LinkedList<>();

		int nowCnt = 0;
		
		while(!que.isEmpty()) {
			int[] to = que.poll();
			int x = to[0];
			int y = to[1];

			for (int k = 0; k < 4; k++) {
				int dx = dr[k] + x;
				int dy = dc[k] + y;
	
				if (dx >= 0 && dx < n && dy >= 0 && dy < m) {
					if (board[dx][dy] == 0) {
						board[dx][dy] = 1;
						nQue.add(new int[] {dx, dy});
						nowCnt++;
					}
				}
			}
		}
		
		if (nowCnt != 0) {
			tomato(nQue, cnt + nowCnt, day + 1);
		} else {
			return;
		}
	}

}