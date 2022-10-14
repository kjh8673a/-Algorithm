import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		int idx = -1;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] == -1) {
				idx = i;
			}
		}

		int min1 = Integer.MAX_VALUE;
		for(int i = 0; i < idx; i++) {
			min1 = Math.min(min1, arr[i]);
		}

		int min2 = Integer.MAX_VALUE;
		for(int i = idx+1; i < n; i++) {
			min2 = Math.min(min2, arr[i]);
		}

		System.out.println(min1 + min2);

	}

}