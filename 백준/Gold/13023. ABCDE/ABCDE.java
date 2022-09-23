import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static boolean[] check;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		list = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
		}

		check = new boolean[n];

		for(int i = 0; i < n; i++) {
			check[i] = true;
			dfs(i, 0);
			check[i] = false;
		}

		System.out.println(0);
	}

	public static void dfs(int idx, int cnt) {	
		if(cnt == 4) {
			System.out.println(1);
			System.exit(0);
			return;
		}

		for(int i = 0; i < list[idx].size(); i++) {
			if(!check[list[idx].get(i)]) {
				check[list[idx].get(i)] = true;
				dfs(list[idx].get(i), cnt+1);
				check[list[idx].get(i)] = false;
			}
		}
	}
}