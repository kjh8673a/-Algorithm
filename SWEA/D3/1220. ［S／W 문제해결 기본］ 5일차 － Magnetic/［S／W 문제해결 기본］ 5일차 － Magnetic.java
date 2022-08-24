import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, K;
	static int[] arr;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for(int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine());

			int[][] arr = new int[n][n];
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					int num = Integer.parseInt(st.nextToken());
					arr[i][j] = num;
				}
			}

			int ans = 0;
			for(int i = 0; i < n; i++) {
				String str = "";
				for(int j = 0; j < n; j++) {
					str += String.valueOf(arr[j][i]);
				}

				str = str.replaceAll("0", "");
				str = str.replaceAll("12", "A");

				ans += count(str, 'A');
				
			}

			sb.append("#" + tc + " ");
			sb.append(ans).append("\n");

		}

		System.out.println(sb.toString());
		
	}

	public static int count(String str, char ch) {
		int cnt = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ch) {
				cnt++;
			}
		}

		return cnt;
	}

}