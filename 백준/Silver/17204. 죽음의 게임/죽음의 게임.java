import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];

		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int idx = 0;
		int cnt = 1;
		while(true) {
			idx = arr[idx];
			if(idx == k) {
				break;
			}
			if(cnt > n) {
				cnt = -1;
				break;
			}
			cnt++;
		}

		System.out.println(cnt);

	}

}