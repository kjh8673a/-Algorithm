import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int L, C;
	static String[] arr;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new String[C];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			arr[i] = st.nextToken();
		}

		// 사전순으로
		Arrays.sort(arr);

		visit = new boolean[C];
		solve(0, 0);

		System.out.println(sb.toString());

	}

	public static void solve(int idx, int pick) {
		// C개의 배열에서 L개 고르기
		if(pick == L) {
			int moeum = 0;
			int jaeum = 0;
			String pw = "";
			for(int i = 0; i < C; i++) {
				if(visit[i]) {
					pw += arr[i];
					if(arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i") || arr[i].equals("o") || arr[i].equals("u")) {
						moeum++;
					}else{
						jaeum++;
					}
				}
			}
			// 최소 한 개의 모음, 최소 두 개의 자음
			if(moeum >= 1 && jaeum >= 2) {
				sb.append(pw).append("\n");
			}
			return;
		}

		if(idx == C) {
			return;
		}

		visit[idx] = true;
		solve(idx+1, pick+1);
		visit[idx] = false;
		solve(idx+1, pick);

	}

}