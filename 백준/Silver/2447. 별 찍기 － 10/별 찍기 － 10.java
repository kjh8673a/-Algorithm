import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	/*
	 * 별 찍기 - 10 - 재귀, 분할정복
	 */
	static String[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		
		arr = new String[n][n];

		makeStar(0, 0, n, false);

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());

	}

	public static void makeStar(int x, int y, int n, boolean blank) {
		
		if(blank) {
			for(int i = x; i < x + n; i++) {
				for(int j = y; j < y + n; j++) {
					arr[i][j] = " ";
				}
			}
			return;
		}

		if(n == 1) {
			arr[x][y] = "*";
			return;
		}

		int size = n / 3;
		for(int i = x; i < x + n; i += size) {
			for(int j = y; j < y + n; j += size) {
				if(i == x+size && j == y + size) {
					makeStar(i, j, size, true);	
				}else {
					makeStar(i, j, size, false);
				}
			}
		}

	}

}