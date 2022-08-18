import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			String str = br.readLine();

			// '()' 를 'L'로 바꿔 레이저 위치를 표시한다
			str = str.replace("()", "L");
	
			// cnt는 현재 쌓여있는 막대기 수
			int cnt = 0;
			// ans는 잘린 막대기 수 = 답
			int ans = 0;
			for(int i = 0; i < str.length(); i++) {
				// 마지막에는 cnt만큼 더해주고 끝낸다
				if(i == str.length()-1) {
					ans += cnt;
					break;
				}
	
				// '(' -> 막대기를 하나 더 쌓았다는 뜻, cnt 하나 더한다
				if(str.charAt(i) == '(') {
					cnt++;
				// ')' -> 막대기를 하나 뺐다는 뜻, cnt를 하나 줄이고 ans를 하나 늘린다
				}else if(str.charAt(i) == ')') {
					cnt--;
					ans++;
				// 'L'이 나오면 레이저 나오기 전까지 cnt만큼 잘라진 것, ans에 더한다
				}else if(str.charAt(i) == 'L') {
					ans+= cnt;
				}
			}

			System.out.println(ans);
	
	}

}