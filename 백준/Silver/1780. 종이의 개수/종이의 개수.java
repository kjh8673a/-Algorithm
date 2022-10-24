import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[] res;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		res = new int[3];

		solve(0, 0, N);

		for(int i = 0; i < 3; i++) {
			System.out.println(res[i]);
		}

	}

	public static void solve(int r, int c, int len) {
		int type = map[r][c];
		
		// 다 같은 숫자로 채워져있다면
		// -1 일때는 res[0], 0일때는 res[1], 1 일때는 res[2]를 각각 증가시킨다
		if(check(r, c, len, type)) {
			if(type == -1) {
				res[0]++;
			}
			if(type == 0) {
				res[1]++;
			}
			if(type == 1) {
				res[2]++;
			}
			return;
		}

		// 기존의 길이를 3등분하여 새로운 사이즈로 각각 재귀 호출한다
		int size = len / 3;
		solve(r, c, size);
		solve(r, c + size, size);
		solve(r, c + size * 2, size);
		solve(r + size, c, size);
		solve(r + size, c + size, size);
		solve(r + size, c + size * 2, size);
		solve(r + size * 2, c, size);
		solve(r + size * 2, c + size, size);
		solve(r + size * 2, c + size * 2, size);
	}

	public static boolean check(int r, int c, int len, int type) {
		for(int i = r; i < r + len; i++) {
			for(int j = c; j < c + len; j++) {
				if(map[i][j] != type) {
					return false;
				}
			}
		}

		return true;
	}
}