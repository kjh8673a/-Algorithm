import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 비숍 - 백트래킹
	 */

	static class Point {
		int r, c;

		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int n, blcnt, wlcnt, bans, wans;
	static int[][] board;
	static List<Point> blist, wlist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		board = new int[n][n];

		blist = new ArrayList<>();
		wlist = new ArrayList<>();
		blcnt = 0;
		wlcnt = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					if((i + j) % 2 != 0) {
						blcnt++;
						blist.add(new Point(i, j));
					}else{
						wlcnt++;
						wlist.add(new Point(i, j));
					}
					
				}
			}
		}

		bans = 0;
		blackbishop(0, 0);

		wans = 0;
		whitebishop(0, 0);

		System.out.println(bans + wans);

	}

	public static void blackbishop(int idx, int cnt) {
		if (cnt + (blcnt - idx) < bans) {
			return;
		}

		if (idx == blcnt) {
			bans = Math.max(bans, cnt);
			return;
		}

		Point p = blist.get(idx);

		int pr = p.r;
		int pc = p.c;

		if (board[pr][pc] == 0) {
			colorBoard(pr, pc, 1);
			blackbishop(idx + 1, cnt + 1);
			colorBoard(pr, pc, -1);
		}
		blackbishop(idx + 1, cnt);

	}

	public static void whitebishop(int idx, int cnt) {
		if (cnt + (wlcnt - idx) < wans) {
			return;
		}

		if (idx == wlcnt) {
			wans = Math.max(wans, cnt);
			return;
		}

		Point p = wlist.get(idx);

		int pr = p.r;
		int pc = p.c;

		if (board[pr][pc] == 0) {
			colorBoard(pr, pc, 1);
			whitebishop(idx + 1, cnt + 1);
			colorBoard(pr, pc, -1);
		}
		whitebishop(idx + 1, cnt);

	}

	public static void colorBoard(int r, int c, int num) {

		board[r][c] += num;

		for (int i = 1; i < n - r; i++) {
			int nr = r + i;
			int nc1 = c + i;
			int nc2 = c - i;

			if (nr < n && nc1 < n) {
				board[nr][nc1] += num;
			}

			if (nr < n && nc2 >= 0) {
				board[nr][nc2] += num;
			}
		}

	}

}