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

		int cnt = 0;
		for (int hour = 0; hour <= n; hour++) {
			if (hour / 10 == k || hour % 10 == k) {
				cnt += 3600;
			} else {
				for (int min = 0; min < 60; min++) {
					if (min / 10 == k || min % 10 == k) {
						cnt += 60;
					} else {
						for (int sec = 0; sec < 60; sec++) {
							if (sec / 10 == k || sec % 10 == k) {
								cnt += 1;
							}
						}
					}
				}
			}
		}

		System.out.println(cnt);

	}

}