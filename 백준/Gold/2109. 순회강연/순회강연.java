import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int pay, day;

		public Node(int pay, int day) {
			this.pay = pay;
			this.day = day;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(o.pay, this.pay);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		int maxDay = 0;
		StringTokenizer st;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if(d > maxDay) {
				maxDay = d;
			}
			pq.add(new Node(p, d));
		}

		boolean[] visit = new boolean[maxDay + 1];

		// 주어진 날짜보다 일찍 강연하러 온다면?
		long ans = 0;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int pay = node.pay;
			int day = node.day;

			if(visit[day]) {
				// 날짜 역순으로 탐색
				// 방문처리 안되있으면 그날에 ㄱㄱ
				int newDay = day - 1;
				while(newDay > 0) {
					if(!visit[newDay]) {
						visit[newDay] = true;
						ans += pay;
						break;
					}else {
						newDay--;
					}
				}
			}else {
				ans += pay;
				visit[day] = true;
			}
		}

		System.out.println(ans);
		
	}

}