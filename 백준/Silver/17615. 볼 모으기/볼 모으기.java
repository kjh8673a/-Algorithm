import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String str = br.readLine();

		// 앞에서부터
		int red = 0;
		int blue = 0;
		char start = str.charAt(0);
		boolean startCnt = false;
		for(int i = 1; i < n; i++) {
			if(str.charAt(i) != start) {
				startCnt = true;
			}
			if(startCnt) {
				if(str.charAt(i) == 'R') {
					red++;
				}else {
					blue++;
				}
			}
		}
		int front = Math.min(red, blue);

		// 뒤에서부터
		red = 0;
		blue = 0;
		start = str.charAt(n-1);
		startCnt = false;
		for(int i = n-2; i >= 0; i--) {
			if(str.charAt(i) != start) {
				startCnt = true;
			}
			if(startCnt) {
				if(str.charAt(i) == 'R') {
					red++;
				}else {
					blue++;
				}
			}
		}
		int back = Math.min(red, blue);
		
		int ans = Math.min(front, back);
		System.out.println(ans);
	}

}