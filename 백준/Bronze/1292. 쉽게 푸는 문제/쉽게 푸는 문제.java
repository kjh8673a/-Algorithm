import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int[] arr = new int[b + 1];

		int num = 1;
		int cnt = 0;
		for (int i = 1; i < b + 1; i++) {
			if (num == cnt) {
				num++;
				cnt = 0;
			}
			arr[i] += num + arr[i - 1];
			cnt++;
		}

		System.out.println(arr[b] - arr[a - 1]);

	}

}