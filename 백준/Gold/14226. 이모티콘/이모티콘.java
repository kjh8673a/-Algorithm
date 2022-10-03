import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int S, ans;
	static boolean[][] visit;

	static class Node {
		int eCnt, cCnt, time;

		Node(int eCnt, int cCnt, int time) {
			this.eCnt = eCnt;
			this.cCnt = cCnt;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		S = Integer.parseInt(br.readLine());

		visit = new boolean[1001][1001];

		ans = 0;

		bfs();

		System.out.println(ans);
	}

	public static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(1, 0, 0));
		visit[1][0] = true;

		while (!queue.isEmpty()) {
			Node now = queue.poll();

			int emoticon = now.eCnt;
			int clipboard = now.cCnt;
			int time = now.time;

			if (emoticon == S) {
				ans = time;
				return;
			}

			// 복사
			if (emoticon > 0 && !visit[emoticon][emoticon]) {
				visit[emoticon][emoticon] = true;
				queue.add(new Node(emoticon, emoticon, time + 1));
			}

			// 붙여넣기
			if (clipboard > 0 && emoticon + clipboard < 1001 && !visit[emoticon + clipboard][clipboard]) {
				visit[emoticon + clipboard][clipboard] = true;
				queue.add(new Node(emoticon + clipboard, clipboard, time + 1));
			}

			// 삭제
			if (emoticon > 0 && !visit[emoticon - 1][clipboard]) {
				visit[emoticon - 1][clipboard] = true;
				queue.add(new Node(emoticon - 1, clipboard, time + 1));
			}

		}

	}

}