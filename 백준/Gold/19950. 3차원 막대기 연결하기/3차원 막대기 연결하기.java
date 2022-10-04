import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int z1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		int z2 = Integer.parseInt(st.nextToken());

		double min = diagonal(x1, y1, z1, x2, y2, z2);

		int n = Integer.parseInt(br.readLine());

		int[] stick = new int[n];

		int sum = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			stick[i] = Integer.parseInt(st.nextToken());
			sum += stick[i];
		}

		Arrays.sort(stick);

		if(min > sum) {
			System.out.println("NO");
		}else {
			if(stick[n-1] - (sum - stick[n-1]) <= min) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}

	}

	public static double diagonal(int x1, int y1, int z1, int x2, int y2, int z2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2));
	}

}