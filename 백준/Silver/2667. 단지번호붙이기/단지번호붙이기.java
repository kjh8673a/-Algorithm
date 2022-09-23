import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
    static int n, cnt;
	static int[][] map;
	static int dan;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());

		map = new int[n][n];

		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < n; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		ArrayList<Integer> list = new ArrayList<>();
		cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 1) {
					dan = 0;
					dfs(i, j);
					cnt++;
					list.add(dan);
				}
			}
		}

		sb.append(cnt).append("\n");

		Collections.sort(list);

		for(int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}

		System.out.println(sb.toString());
    }

	public static void dfs(int x, int y) {
		dan++;
		map[x][y] = 0;

		for(int i = 0; i < 4; i++) {
			int nr = x + dr[i];
			int nc = y + dc[i];

			if(nr >= 0 && nc >= 0 && nr < n && nc < n) {
				if(map[nr][nc] == 1) {
					dfs(nr, nc);
				}
			}
		}
	}
}