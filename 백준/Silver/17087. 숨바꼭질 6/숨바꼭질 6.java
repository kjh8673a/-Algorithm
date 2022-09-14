import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];

		// a-s의 절대값을 배열에 넣어준다
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken());
			arr[i] = Math.abs(s - a);
		}

		// n이 1인경우 s와 a의 차이를 출력하고
		// n > 1인경우 각 수들의 최대공약수를 구한다
		if(n == 1) {
			System.out.println(arr[0]);
		}else {
			Arrays.sort(arr);

			int gcd = hose(arr[1], arr[0]);

			for(int i = 2; i < n; i++) {
				gcd = hose(arr[i], gcd);
			}

			System.out.println(gcd);
		}

	}

	// 유클리드 호제법
	// a를 b로 나눈 나머지를 r이라 하면 a와 b의 최대공약수는 b와 r의 최대공약수와 같다
	// 과정을 반복하여 나머지가 0이 되었을 때 나누는 수가 a와 b의 최대공약수이다
	public static int hose(int a, int b) {
		if (a % b != 0) {
			return hose(b, a % b);
		} else {
			return b;
		}
	}

}