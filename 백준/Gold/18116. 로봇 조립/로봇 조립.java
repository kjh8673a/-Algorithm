import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static int[] parent, rank;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		parent = new int[1000001];
		rank = new int[1000001];

		HashSet<Integer> list = new HashSet<>();
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine());
			String type = st.nextToken();

			if (type.equals("I")) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (!list.contains(a)) {
					makeSet(a);
					list.add(a);
				}
				if (!list.contains(b)) {
					makeSet(b);
					list.add(b);
				}
				if(findSet(a) != findSet(b)) {
					union(a, b);
				}
			} else {
				int c = Integer.parseInt(st.nextToken());
				if (!list.contains(c)) {
					makeSet(c);
					list.add(c);
				}
				sb.append(rank[findSet(c)]).append("\n");
			}
		}

		System.out.println(sb.toString());

	}

	public static void makeSet(int x) {
		parent[x] = x;
		rank[x] = 1;
	}

	public static int findSet(int x) {
		if (x == parent[x]) {
			return x;
		} else {
			parent[x] = findSet(parent[x]);
			return parent[x];
		}
	}

	public static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		if (rank[px] > rank[py]) {
			parent[py] = px;
			rank[px] += rank[py];
		} else {
			parent[px] = py;
			rank[py] += rank[px];
		}
	}

}