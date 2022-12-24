import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, res;
	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 노트북 세로 길이
		M = Integer.parseInt(st.nextToken()); // 노트북 가로 길이
		int K = Integer.parseInt(st.nextToken()); // 스티커의 개수

		board = new int[N][M];

		res = 0;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			int[][] sticker = new int[R][C];

			for (int j = 0; j < R; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < C; k++) {
					sticker[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			for (int j = 0; j < 4; j++) {
				if (check(sticker)) { // 스티커를 붙일 수 있는 자리가 있다면
					break;
				} else { // 붙일 자리가 없다면 스티커 90도 회전
					sticker = rotate(sticker);
				}
			}
		}

		System.out.println(res);
	}

	public static boolean check(int[][] sticker) {
		for (int i = 0; i < N - sticker.length + 1; i++) {
			for (int j = 0; j < M - sticker[0].length + 1; j++) {
				if (possible(sticker, i, j)) { // 현재 자리에 스티커를 붙일 수 있으면
					put(sticker, i, j); // 스티커 붙이기
					return true;
				}
			}
		}
		return false;
	}

	public static boolean possible(int[][] sticker, int r, int c) {
		for (int i = 0; i < sticker.length; i++) {
			for (int j = 0; j < sticker[0].length; j++) {
				if (board[i + r][j + c] == 1 && sticker[i][j] == 1) { // board와 sticker 둘 다 1이면 붙일 수 없다
					return false;
				}
			}
		}
		return true;
	}

	public static void put(int[][] sticker, int r, int c) {
		for (int i = 0; i < sticker.length; i++) {
			for (int j = 0; j < sticker[0].length; j++) {
				if (sticker[i][j] == 1) { // 스티커 붙일 때 스티커가 1이면 res 1 증가
					board[i + r][j + c] = sticker[i][j];
					res++;
				}
			}
		}
	}

	public static int[][] rotate(int[][] sticker) {
		int[][] newSticker = new int[sticker[0].length][sticker.length];

		for (int i = 0; i < sticker.length; i++) {
			for (int j = 0; j < sticker[0].length; j++) {
				newSticker[j][sticker.length - 1 - i] = sticker[i][j];
			}
		}

		return newSticker;
	}
}