import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int n, ans;
	static ArrayList<Integer> numbers;
	static ArrayList<Character> symbols;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		String s = br.readLine();
		numbers = new ArrayList<>();
		symbols = new ArrayList<>();
		for(int i = 0; i < s.length(); i++) {
			if(i%2 == 0) {
				numbers.add(s.charAt(i) - '0');
			}else {
				symbols.add(s.charAt(i));	
			}
		}

		ans = Integer.MIN_VALUE;

		dfs(0, numbers.get(0));

		System.out.println(ans);
		
	}

	public static void dfs(int idx, int sum) {
		if(idx == symbols.size()) {
			ans = Math.max(ans, sum);
			return;
		}

		// 괄호 안치고 넘어가기 => A + B
		int a = cal(symbols.get(idx), sum, numbers.get(idx + 1));
		dfs(idx + 1, a);

		// 괄호 치고 넘어가기 => A + (B + C)
		if(idx + 2 <= symbols.size()) {
			int b = cal(symbols.get(idx + 1), numbers.get(idx + 1), numbers.get(idx + 2));
			int c = cal(symbols.get(idx), sum, b);
			dfs(idx + 2, c);
		}
	
	}

	public static int cal(char sym, int a, int b) {
		int now = 0;
		switch(sym) {
			case '+':
				now = a + b;
				break;
			case '-':
			now = a - b;
				break;
			case '*':
				now = a * b;
				break;
		}
		return now;
	}

}