import java.io.IOException;
import java.util.Scanner;

public class Main {
	static class Node {
		double a, b;

		public Node(double a, double b) {
			this.a = a;
			this.b = b;
		}
	}

	static double[][] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			arr = new double[4][2];

			for (int i = 0; i < 4; i++) {
				arr[i][0] = sc.nextDouble();
				arr[i][1] = sc.nextDouble();
			}

			if (arr[0][0] == arr[2][0] && arr[0][1] == arr[2][1]) {
				find(new Node(arr[0][0], arr[0][1]), new Node(arr[1][0], arr[1][1]), new Node(arr[3][0], arr[3][1]));
			} else if (arr[0][0] == arr[3][0] && arr[0][1] == arr[3][1]) {
				find(new Node(arr[0][0], arr[0][1]), new Node(arr[1][0], arr[1][1]), new Node(arr[2][0], arr[2][1]));
			} else if (arr[1][0] == arr[2][0] && arr[1][1] == arr[2][1]) {
				find(new Node(arr[1][0], arr[1][1]), new Node(arr[0][0], arr[0][1]), new Node(arr[3][0], arr[3][1]));
			} else if (arr[1][0] == arr[3][0] && arr[1][1] == arr[3][1]) {
				find(new Node(arr[1][0], arr[1][1]), new Node(arr[0][0], arr[0][1]), new Node(arr[2][0], arr[2][1]));
			}

		}
		
		sc.close();

	}

	public static void find(Node a, Node b, Node c) {
		double x1 = a.a;
		double y1 = a.b;
		double x2 = b.a;
		double y2 = b.b;
		double x3 = c.a;
		double y3 = c.b;

		double x_tmp = (x2 + x3) / 2;
		double y_tmp = (y2 + y3) / 2;

		double dx = x_tmp + (x_tmp - x1);
		double dy = y_tmp + (y_tmp - y1);

		System.out.println(String.format("%.3f %.3f", dx, dy));
	}

}