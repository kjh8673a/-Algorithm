import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] pi;
	static Queue<Integer> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String T = br.readLine();
		String P = br.readLine();

		pi = makeTable(P);

		queue = new LinkedList<>();
		int ans = doKMP(T, P);

		StringBuilder sb = new StringBuilder();
		sb.append(ans).append("\n");
		while (!queue.isEmpty()) {
			sb.append(queue.poll() + " ");
		}
		System.out.println(sb.toString());

	}

	public static int doKMP(String str, String pattern) {
		int slen = str.length();
		int plen = pattern.length();

		int ans = 0;
		int idx = 0; // 패턴의 몇번째 글자를 보고있는지
		// str의 길이만큼만 탐색하기 때문에 O(n)의 시간복잡도
		for (int i = 0; i < slen; i++) {
			// 패턴의 idx번째 글자와 불일치할 경우
			// pi[idx-1]로 idx를 설정하고 그 글자부터 다시 본다
			// pi[idx-1]이 1이라면 패턴에서 앞 2글자까지는 일치하고 있다는 뜻
			// 이미 일치했다고 나온 부분은 비교할 필요가 없다
			while (idx > 0 && str.charAt(i) != pattern.charAt(idx)) {
				idx = pi[idx - 1];
			}

			if (str.charAt(i) == pattern.charAt(idx)) {
				// idx가 패턴의 길이까지 탐색했다면 다 일치한 것
				// 아직 끝까지 간 것이 아니라면 idx를 1증가하여 다음 글자와 비교
				if (idx == plen - 1) {
					ans += 1;
					queue.add(i - idx + 1);
					idx = pi[idx];
				} else {
					idx += 1;
				}
			}
		}

		return ans;
	}

	public static int[] makeTable(String pattern) {
		int n = pattern.length();
		int[] table = new int[n];

		int idx = 0;
		for (int i = 1; i < n; i++) {
			// 연속으로 일치하지 않으면 idx값을 돌려주고 다시 매칭
			while (idx > 0 && pattern.charAt(i) != pattern.charAt(idx)) {
				idx = table[idx - 1];
			}

			// 일치하면 table[i]에 몇번째 글자까지 일치했는지 적어주고
			// 다음 문자 비교
			if (pattern.charAt(i) == pattern.charAt(idx)) {
				idx += 1;
				table[i] = idx;
			}
		}

		return table;
	}

}