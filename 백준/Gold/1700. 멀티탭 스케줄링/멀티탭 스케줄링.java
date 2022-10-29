import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[K];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
		}

		boolean[] use = new boolean[K + 1];

		int cnt = 0;
		int ans = 0;
		for (int i = 0; i < K; i++) {
			if (use[arr[i]]) {
				continue;
			}

			if (cnt < N) {
				use[arr[i]] = true;
				cnt++;
			} else {
				ArrayList<Integer> list = new ArrayList<>();
				for (int j = i; j < K; j++) {
					if (list.size() + 1 == N) {
						break;
					}
					if (use[arr[j]] && !list.contains(arr[j])) {
						list.add(arr[j]);
					}
				}

				for (int j = 0; j < K; j++) {
					if (use[j] && !list.contains(j)) {
						use[j] = false;
						break;
					}
				}
				use[arr[i]] = true;
				ans++;
			}
		}

		System.out.println(ans);

	}

}