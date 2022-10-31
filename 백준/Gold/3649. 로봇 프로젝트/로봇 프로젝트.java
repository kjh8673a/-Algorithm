import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력은 여러개로 들어온다!!!! EOF
		String input = "";

		while ((input = br.readLine()) != null && !input.isEmpty()) {
			// 구멍의 너비(센티미터 -> 1cm = 10000000nm)
			int x = Integer.parseInt(input);
			x *= 10000000;

			int n = Integer.parseInt(br.readLine());
			int[] lego = new int[n];

			for (int i = 0; i < n; i++) {
				lego[i] = Integer.parseInt(br.readLine());
			}

			// 투포인터
			// 정렬하고 나서 left + right하면서
			// 원하는 값보다 크면 right를 하나씩 줄여서 값이 작아지도록
			// 원하는 값보다 작으면 left를 하나씩 높여서 값이 커지도록
			Arrays.sort(lego);

			int left = 0;
			int right = n - 1;

			boolean isPossible = false;
			while (left < right) {
				if (lego[left] + lego[right] == x) {
					isPossible = true;
					break;
				} else if (lego[left] + lego[right] > x) {
					right--;
				} else {
					left++;
				}
			}

			if (isPossible) {
				System.out.println("yes " + lego[left] + " " + lego[right]);
			} else {
				System.out.println("danger");
			}
		}

	}

}