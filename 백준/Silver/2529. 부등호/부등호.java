import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int k;
	static String[] symbol;
	static Deque<String> deque;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		k = Integer.parseInt(br.readLine());

		symbol = new String[k];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < k; i++) {
			symbol[i] = st.nextToken();
		}

		deque = new LinkedList<>();

		visit = new boolean[10];

		dfs(0, "");

		// 최댓값 & 최솟값
		System.out.println(deque.peekLast());
		System.out.println(deque.peekFirst());
		
	}

	public static void dfs(int idx, String ans) {
		if(idx == k+1) {
			deque.add(ans);
			return;
		}

		for(int i = 0; i < 10; i++) {
			// 맨 앞자리수
			if(idx == 0) {
				visit[i] = true;
				dfs(idx + 1, ans + String.valueOf(i));
				visit[i] = false;
			}
			
			// 두 번째 수부터는 부등호 체크
			else {
				String s = symbol[idx-1];
				switch(s) {
					// 아직 쓰인적이 없고, 이전 숫자보다 크다면 넣을 수 있다
					case "<":
						if(!visit[i] && ans.charAt(idx-1)-'0'< i) {
							visit[i] = true;
							dfs(idx + 1, ans + String.valueOf(i));
							visit[i] = false;
						}
						break;
					// 아직 쓰인적이 없고, 이전 숫자보다 작다면 넣을 수 있다
					case ">":
					if(!visit[i] && ans.charAt(idx-1)-'0'> i) {
						visit[i] = true;
						dfs(idx + 1, ans + String.valueOf(i));
						visit[i] = false;
					}
					break;
				}
			}
			
		}

	}

}