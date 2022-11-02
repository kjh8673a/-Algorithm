import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static Character[][] star;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		star = new Character[N][N * 2];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N * 2; j++) {
				star[i][j] = ' ';
			}
		}

		makeStar(0, N - 1, N);

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N * 2; j++) {
				sb.append(star[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	public static void makeStar(int r, int c, int len) {
		if(len == 3) {
			star[r][c] = '*';
			star[r+1][c-1] = '*';
			star[r+1][c+1] = '*';
			star[r+2][c-2] = '*';
			star[r+2][c-1] = '*';
			star[r+2][c] = '*';
			star[r+2][c+1] = '*';
			star[r+2][c+2] = '*';
			return;
		}

		int size = len / 2;

		makeStar(r, c, size);
		makeStar(r + size, c - size, size);
		makeStar(r + size, c + size, size);
	}
}