import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	/*
	 * CCW알고리즘
	 * | x1 x2 x3 x1 |
	 * | y1 y2 y3 y1 |
	 * (x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1)
	 * > 0 ==> 반시계방향
	 * = 0 ==> 일직선
	 * < 0 ==> 시계방향
	 * AB 선분 기준 C, D가 반대편에 있다 --> ccw(ABC) * ccw(ABD) < 0
	 * CD 선분 기준 A, B가 반대편에 있다 --> ccw(CDA) * ccw(CDB) < 0
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		// A
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		// B
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		// C
		int x3 = Integer.parseInt(st.nextToken());
		int y3 = Integer.parseInt(st.nextToken());
		// D
		int x4 = Integer.parseInt(st.nextToken());
		int y4 = Integer.parseInt(st.nextToken());

		int ABC = ccw(x1, y1, x2, y2, x3, y3);
		int ABD = ccw(x1, y1, x2, y2, x4, y4);
		int CDA = ccw(x3, y3, x4, y4, x1, y1);
		int CDB = ccw(x3, y3, x4, y4, x2, y2);

		if (ABC * ABD < 0 && CDA * CDB < 0) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}

	public static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
		long tmp = (x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1);
		if (tmp > 0) {
			return 1; // 반시계
		} else if (tmp == 0) {
			return 0; // 일직선
		} else {
			return -1; // 시계
		}
	}

}