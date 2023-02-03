import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		char[][] board = new char[R][C];
		for(int i = 0; i < R; i++) {
			String s = br.readLine();
			for(int j = 0; j < C; j++) {
				board[i][j] = s.charAt(j);
			}
		}

		int[] ans = new int[5];
		for(int i = 0; i < R - 1; i++) {
			for(int j = 0; j < C - 1; j++) {
				if(board[i][j] == '#' || board[i + 1][j] == '#' || board[i][j + 1] == '#' || board[i + 1][j + 1] == '#') continue;

				int cnt = 0;
				if(board[i][j] == 'X') cnt++;
				if(board[i + 1][j] == 'X') cnt++;
				if(board[i][j + 1] == 'X') cnt++;
				if(board[i + 1][j + 1] == 'X') cnt++;

				ans[cnt]++;
			}
		}

		for(int i = 0; i < 5; i++) {
			System.out.println(ans[i]);
		}		

	}

}