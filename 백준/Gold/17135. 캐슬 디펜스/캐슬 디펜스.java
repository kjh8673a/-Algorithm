import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, d, total, cnt;
	static int[][] original, map;
	static boolean[] location;

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		original = new int[n][m];

		total = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				original[i][j] = Integer.parseInt(st.nextToken());
				if (original[i][j] == 1) {
					total++;
				}
			}
		}

		location = new boolean[m];

		cnt = 0;

		putArcher(0, 0);

		System.out.println(cnt);

	}

	public static void putArcher(int idx, int cnt) {
		if (cnt == 3) {
			map = new int[n][m];

			for (int i = 0; i < n; i++) {
				System.arraycopy(original[i], 0, map[i], 0, map[i].length);
			}

			attack(0, total, n);
			return;
		}
		if (idx >= m) {
			return;
		}

		location[idx] = true;
		putArcher(idx + 1, cnt + 1);
		location[idx] = false;
		putArcher(idx + 1, cnt);
	}

	public static void attack(int capcnt, int total, int line) {

		int enemyKill = 0;
		int enemyDie = 0;

		while (line >= 0) {
			if (enemyDie == total) {
				cnt = Math.max(enemyKill, cnt);
				return;
			}

			Queue<Integer> archer = new LinkedList<>();
			for (int i = 0; i < m; i++) {
				if (location[i]) {
					archer.add(i);
				}
			}

			Queue<Node> enemy = new LinkedList<>();

			// 잡을 수 있는 적 찾기
			while (!archer.isEmpty()) {
				int loc = archer.poll();

				int dist = 1;
				while (dist <= d) {
					boolean capture = false;
					loop1: for (int i = 1; i <= dist; i++) {
						for (int j = dist - i; j >= 0; j--) {
							if (line - i >= 0 && loc - j >= 0 && line - i < line && loc - j < m
									&& map[line - i][loc - j] == 1) {
								enemy.add(new Node(line - i, loc - j));
								capture = true;
								break loop1;
							}
						}
					}

					if (!capture) {
						loop2: for (int i = dist-1; i > 0; i--) {
							for (int j = 1; j <= dist-i; j++) {
								if (line - i >= 0 && loc + j >= 0 && line - i < line && loc + j < m
										&& map[line - i][loc + j] == 1) {
									enemy.add(new Node(line - i, loc + j));
									capture = true;
									break loop2;
								}
							}
						}
					}

					if (capture) {
						break;
					} else {
						dist++;
					}
				}
			}

			// 적 사살
			while (!enemy.isEmpty()) {
				Node node = enemy.poll();
				int nr = node.r;
				int nc = node.c;
				if (map[nr][nc] == 1) {
					map[nr][nc] = 0;
					enemyKill++;
					enemyDie++;
				}
			}

			// 적 한칸씩 아래로 == 성 한칸 위로
			for (int i = 0; i < m; i++) {
				if (line - 1 >= 0 && line - 1 < line) {
					if (map[line - 1][i] == 1) {
						map[line - 1][i] = 0;
						enemyDie++;
					}
				}
			}

			line--;
		}

	}

}