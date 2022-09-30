import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		parent = new int[n+1];
		for(int i = 1; i < n+1; i++) {
			parent[i] = i;
		}

		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				int link = Integer.parseInt(st.nextToken());
				if(link == 1) {
					union(i+1, j+1);
				}
			}
		}

		boolean isPossible = true;
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int root = findSet(start);
		for(int i = 0; i < m-1; i++) {
			int city = Integer.parseInt(st.nextToken());
			if(root != findSet(city)) {
				isPossible = false;
			}
		}

		if(isPossible) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}

	}

	public static int findSet(int x) {
        if(x == parent[x]) {
            return x;
        }else {
            parent[x] = findSet(parent[x]);
            return parent[x];
        }
    }

    public static void union(int x, int y) {
        int px = findSet(x);
        int py = findSet(y);

        if(px > py) {
            parent[py] = px;
        }else {
            parent[px] = py;
        }
    }

}