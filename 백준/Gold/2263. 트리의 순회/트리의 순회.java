import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int n;
	static int[] inOrder, postOrder;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		inOrder = new int[n];
		postOrder = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			inOrder[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			postOrder[i] = Integer.parseInt(st.nextToken());
		}

		solve(0, n-1, 0, n-1);

		System.out.println(sb.toString());
	}

	public static void solve(int inStart, int inEnd, int postStart, int postEnd) {
		
		if(inStart <= inEnd && postStart <= postEnd) {
			int root = postOrder[postEnd];
			
			sb.append(root + " ");
			
			int tmp = 0;

			for(int i = inEnd; i >= 0; i--) {
				if(inOrder[i] == root) {
					tmp = i;
					break;
				}
			}

			int len = inEnd - tmp;

			solve(inStart, tmp - 1, postStart, postEnd - (len + 1));

			solve(inStart, inEnd, postEnd - len, postEnd - 1);
		}

	}
}