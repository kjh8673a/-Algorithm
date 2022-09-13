import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int len = 0;
		while(Math.pow(b, len) <= num) {
			len++;
		}

		String ans = "";
		for(int i = len-1; i >= 0; i--) {
			int now = (int) (num / Math.pow(b, i));
			if(now >= 10) {
				ans += (char)(now+55);
			}else {
				ans += String.valueOf(now);
			}
			num = (int) (num % Math.pow(b, i));
		}

		System.out.println(ans);
	}

}