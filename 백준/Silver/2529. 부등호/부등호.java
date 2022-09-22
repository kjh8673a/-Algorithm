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

		System.out.println(deque.peekLast());
		System.out.println(deque.peekFirst());
		
	}

	public static void dfs(int idx, String ans) {
		if(idx == k+1) {
			deque.add(ans);
			return;
		}

		for(int i = 0; i < 10; i++) {
			if(idx == 0) {
				visit[i] = true;
				dfs(idx + 1, ans + String.valueOf(i));
				visit[i] = false;
			}else {
				String s = symbol[idx-1];
				switch(s) {
					case "<":
						if(!visit[i] && ans.charAt(idx-1)-'0'< i) {
							visit[i] = true;
							dfs(idx + 1, ans + String.valueOf(i));
							visit[i] = false;
						}
						break;
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