import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for(int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());

			// n개의 숫자를 배열에 넣고 정렬해준다
			int[] arr = new int[n];
			for(int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);

			// (0, 1)쌍부터 (n-2, n-1)쌍까지 모든 경우를 계산한다
			long ans = 0;
			for(int k = 0; k < n-1; k++) {
				for(int l = k+1; l < n; l++) {
					ans += hose(arr[l], arr[k]);
				}
			}

			sb.append(ans).append("\n");
		}		

		System.out.println(sb.toString());

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