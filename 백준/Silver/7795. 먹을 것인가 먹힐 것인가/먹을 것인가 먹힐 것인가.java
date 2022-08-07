import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int t = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] a = new int[n];
			int[] b = new int[m];
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				a[j] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				b[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(a);
			Arrays.sort(b);

			int ans = 0;
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < m; k++) {
					if(a[j] <= b[k]) {
						ans += k;
						break;
					}
					if(k == m-1) {
						ans += m;
					}
				}
			}

			System.out.println(ans);
		}
		
		br.close();

	}
}
