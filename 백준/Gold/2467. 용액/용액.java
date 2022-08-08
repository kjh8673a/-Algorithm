import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		br.close();

		int min = Integer.MAX_VALUE;
		int a = 0;
		int b = 0;
		Arrays.sort(arr);
		int left = 0;
		int right = n-1;
		while(left < right) {
			int sum = arr[left] + arr[right];

			if(Math.abs(sum) < min) {
				min = Math.abs(sum);
				a = arr[left];
				b = arr[right];
				if(sum==0) break;
			}

			if(sum < 0) {
				left++;
			}else {
				right--;
			}
		}

		System.out.println(a + " " + b);

	}
}