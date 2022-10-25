import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			// 서류 성적은 0에, 면접 성적은 1에 저장
			int[][] score = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				score[i][0] = Integer.parseInt(st.nextToken());
				score[i][1] = Integer.parseInt(st.nextToken());
			}

			// 서류 성적을 기준으로 오름차순 정렬
			Arrays.sort(score, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[0] - o2[0];
				}
			});

			// 서류 성적은 오름차순 정렬되있으므로
			// 이전사람보다 순위가 좋으면 뽑는다
			int pick = 1; // 1등은 뽑고 시작하자

			int tmp = score[0][1];
			for (int i = 1; i < N; i++) {
				if(tmp > score[i][1]) {
					pick++;
					tmp = score[i][1]; // 순위가 더 좋은 참가자가 있다면 그걸로 판단 기준을 바꿔주자
				}
			}

			sb.append(pick).append("\n");
		}

		System.out.println(sb.toString());

	}

}