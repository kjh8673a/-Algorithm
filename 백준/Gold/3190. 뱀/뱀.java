import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, L;
	static int[][] board, move;
	static Deque<Node> snake;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		board = new int[N][N];
		board[0][0] = 1;

		// 사과의 위치
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			// 사과는 4
			board[a][b] = 4;
		}

		// 방향 변환 정보
		L = Integer.parseInt(br.readLine());
		move = new int[L + 1][2];
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			move[i][0] = a;
			// 오른쪽은 1, 왼쪽은 -1
			if (s.equals("D")) {
				move[i][1] = 1;
			} else {
				move[i][1] = -1;
			}
		}

		snake = new ArrayDeque<>();
		snake.add(new Node(0, 0));
		solve(0, 1, 1);

	}

	public static void solve(int idx, int dir, int time) {
		Node node = snake.peekLast();
		int hr = node.r;
		int hc = node.c;
		int next_dir = dir;
		int next_idx = idx;
		
		// 1: 우, 2: 하, 3: 좌, 4: 상
		switch (dir) {
			case 1:
				if (hc + 1 >= N) {
					System.out.println(time);
					return;
				}

				if (board[hr][hc + 1] == 1) {
					System.out.println(time);
					return;
				}

				if (board[hr][hc + 1] == 4) {
					board[hr][hc + 1] = 1;
					snake.addLast(new Node(hr, hc + 1));
				} else {
					board[hr][hc + 1] = 1;
					snake.addLast(new Node(hr, hc + 1));
					Node tail = snake.pollFirst();
					board[tail.r][tail.c] = 0;
				}

				if (time == move[idx][0]) {
					if (move[idx][1] == 1) {
						next_dir = 2;
					} else {
						next_dir = 4;
					}
					next_idx++;
				}

				solve(next_idx, next_dir, time + 1);
				break;

			case 2:
				if (hr + 1 >= N) {
					System.out.println(time);
					return;
				}

				if (board[hr + 1][hc] == 1) {
					System.out.println(time);
					return;
				}

				if (board[hr + 1][hc] == 4) {
					board[hr + 1][hc] = 1;
					snake.addLast(new Node(hr + 1, hc));
				} else {
					board[hr + 1][hc] = 1;
					snake.addLast(new Node(hr + 1, hc));
					Node tail = snake.pollFirst();
					board[tail.r][tail.c] = 0;
				}

				if (time == move[idx][0]) {
					if (move[idx][1] == 1) {
						next_dir = 3;
					} else {
						next_dir = 1;
					}
					next_idx++;
				}

				solve(next_idx, next_dir, time + 1);
				break;

			case 3:
				if (hc - 1 < 0) {
					System.out.println(time);
					return;
				}

				if (board[hr][hc - 1] == 1) {
					System.out.println(time);
					return;
				}

				if (board[hr][hc - 1] == 4) {
					board[hr][hc - 1] = 1;
					snake.addLast(new Node(hr, hc - 1));
				} else {
					board[hr][hc - 1] = 1;
					snake.addLast(new Node(hr, hc - 1));
					Node tail = snake.pollFirst();
					board[tail.r][tail.c] = 0;
				}

				if (time == move[idx][0]) {
					if (move[idx][1] == 1) {
						next_dir = 4;
					} else {
						next_dir = 2;
					}
					next_idx++;
				}

				solve(next_idx, next_dir, time + 1);
				break;

			case 4:
				if (hr - 1 < 0) {
					System.out.println(time);
					return;
				}

				if (board[hr - 1][hc] == 1) {
					System.out.println(time);
					return;
				}

				if (board[hr - 1][hc] == 4) {
					board[hr - 1][hc] = 1;
					snake.addLast(new Node(hr - 1, hc));
				} else {
					board[hr - 1][hc] = 1;
					snake.addLast(new Node(hr - 1, hc));
					Node tail = snake.pollFirst();
					board[tail.r][tail.c] = 0;
				}

				if (time == move[idx][0]) {
					if (move[idx][1] == 1) {
						next_dir = 1;
					} else {
						next_dir = 3;
					}
					next_idx++;
				}

				solve(next_idx, next_dir, time + 1);
				break;
		}
	}

}