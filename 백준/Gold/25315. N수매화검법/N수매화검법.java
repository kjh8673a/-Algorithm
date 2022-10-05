import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	/*
	 * CCW알고리즘
	 * | x1 x2 x3 x1 |
	 * | y1 y2 y3 y1 |
	 * (x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1)
	 * || (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1)
	 * > 0 ==> 반시계방향
	 * = 0 ==> 일직선
	 * < 0 ==> 시계방향
	 * AB 선분 기준 C, D가 반대편에 있다 --> ccw(ABC) * ccw(ABD) < 0
	 * CD 선분 기준 A, B가 반대편에 있다 --> ccw(CDA) * ccw(CDB) < 0
	 * 
	 * 가중치로 정렬하여 가중치가 적은것부터 먼저 실행한다
	 */
	static class Point {
		long x, y;

		Point (long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
	static class Line {
		Point p1, p2;
		long w;

		Line(long a, long b, long c, long d, long w) {
			this.p1 = new Point(a, b);
			this.p2 = new Point(c, d);
			this.w = w;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		List<Line> line = new ArrayList(n);

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			long x1 = Long.parseLong(st.nextToken());
			long y1 = Long.parseLong(st.nextToken());
			long x2 = Long.parseLong(st.nextToken());
			long y2 = Long.parseLong(st.nextToken());
			long w = Long.parseLong(st.nextToken());
			line.add(new Line(x1, y1, x2, y2, w));
		}

		Collections.sort(line, new Comparator<Line>() {
			@Override
			public int compare(Line o1, Line o2) {
				return Long.compare(o1.w, o2.w);
			}
		});

		long sum = 0;

		for (int i = 0; i < n; i++) {
			int cnt = 0;
			for (int j = i+1; j < n; j++) {
				if (cross(line.get(i), line.get(j))) {
					cnt++;
				}
			}
			sum += (cnt + 1) * line.get(i).w;
		}

		System.out.println(sum);

	}

	public static boolean cross(Line a1, Line a2) {
		return ccw(a1.p1.x, a1.p1.y, a1.p2.x, a1.p2.y, a2.p1.x, a2.p1.y) * ccw(a1.p1.x, a1.p1.y, a1.p2.x, a1.p2.y, a2.p2.x, a2.p2.y) <= 0
				&& ccw(a2.p1.x, a2.p1.y, a2.p2.x, a2.p2.y, a1.p1.x, a1.p1.y) * ccw(a2.p1.x, a2.p1.y, a2.p2.x, a2.p2.y, a1.p2.x, a1.p2.y) <= 0;
	}

	public static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
		long tmp = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);
		if (tmp == 0) {
			return 0; // 일직선
		} else if (tmp > 0) {
			return 1; // 반시계방향
		} else {
			return -1; // 시계방향
		}
	}

}