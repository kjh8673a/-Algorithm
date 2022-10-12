import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, ans;
	static int[][] player;
	static int[] team;
	static boolean[] picked;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		player = new int[n][9];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				player[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		team = new int[9];
		picked = new boolean[9];

		team[3] = 0;
		picked[3] = true;

		ans = 0;
		makeTeam(1);

		System.out.println(ans);

	}

	public static void makeTeam(int idx) {
		if (idx == 9) {
			baseball();
		}

		for (int i = 0; i < 9; i++) {
			if (picked[i]) {
				continue;
			}
			picked[i] = true;
			team[i] = idx;
			makeTeam(idx + 1);
			picked[i] = false;
		}
	}

	public static void baseball() {
		int score = 0;

		int idx = 0;

		for (int i = 0; i < n; i++) {
			int out = 0;
			boolean[] base = new boolean[4];

			while (out < 3) {
				int hit = player[i][team[idx]];

				switch (hit) {
					case 0:
						out++;
						break;
					case 1:
						if (base[3]) {
							score++;
							base[3] = false;
						}
						if (base[2]) {
							base[2] = false;
							base[3] = true;
						}
						if (base[1]) {
							base[1] = false;
							base[2] = true;
						}
						base[1] = true;
						break;
					case 2:
						if (base[3]) {
							score++;
							base[3] = false;
						}
						if (base[2]) {
							score++;
							base[2] = false;
						}
						if (base[1]) {
							base[1] = false;
							base[3] = true;
						}
						base[2] = true;
						break;
					case 3:
						if (base[3]) {
							score++;
							base[3] = false;
						}
						if (base[2]) {
							score++;
							base[2] = false;
						}
						if (base[1]) {
							score++;
							base[1] = false;
						}
						base[3] = true;
						break;
					case 4:
						if (base[3]) {
							score++;
							base[3] = false;
						}
						if (base[2]) {
							score++;
							base[2] = false;
						}
						if (base[1]) {
							score++;
							base[1] = false;
						}
						score++;
						break;
				}

				idx++;
				if(idx == 9) {
					idx = 0;
				}
			}
		
		}

		ans = Math.max(ans, score);

	}

}