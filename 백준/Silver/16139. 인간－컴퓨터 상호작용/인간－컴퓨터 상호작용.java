import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();

		int[][] alpha = new int[str.length()][26];

		alpha[0][str.charAt(0) - 'a']++;

		for(int i = 1; i < str.length(); i++) {
			alpha[i][str.charAt(i) - 'a']++;

			for(int j = 0; j < 26; j++) {
				alpha[i][j] += alpha[i-1][j];
			}
		}

		int n = Integer.parseInt(br.readLine());

		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String find = st.nextToken();
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			int num = find.charAt(0) - 'a';

			if(start == 0) {
				sb.append(alpha[end][num]).append("\n");
			}else {
				sb.append(alpha[end][num] - alpha[start-1][num]).append("\n");
			}
		}

		System.out.println(sb.toString());
		
	}

}