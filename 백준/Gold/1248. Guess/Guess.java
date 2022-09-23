import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n, chk;
	static char[][] symbol;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		symbol = new char[n][n];
		
		String s = br.readLine();
		int idx = 0;
		for(int i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				symbol[i][j] = s.charAt(idx++);
			}
		}

		chk = 0;
		arr = new int[n];

		makeArr(0);

	}

	public static void makeArr(int depth) {

		if(depth == n) {
			if(chk == 0) {
				chk = 1;
				for(int i = 0; i < n; i++) {
					sb.append(arr[i] + " ");
				}
				System.out.println(sb.toString());
				System.exit(0);
			}
			return;
		}

		switch(symbol[depth][depth]) {
			case '-' :
				for(int k = -1; k >= -10; k--) {
					arr[depth] = k;
					if(checkNow(depth)) {
						makeArr(depth+1);
					}
				}
				break;
			
			case '+' :
				for(int k = 1; k <= 10; k++) {
					arr[depth] = k;
					if(checkNow(depth)) {
						makeArr(depth+1);
					}
				}
				break;

			case '0' :
				arr[depth] = 0;
				if(checkNow(depth)) {
					makeArr(depth+1);
				}
				break;
		}
	}

	public static boolean checkNow(int num) {

		for(int i = 0; i < num; i++) {
			int j = num;
			int sum = 0;
			for(int k = i; k <= j; k++) {
				sum += arr[k];
			}

			switch(symbol[i][j]) {
				case '-' :
					if(sum >= 0) {
						return false;
					}
					break;
				case '+' :
					if(sum <= 0) {
						return false;
					}
					break;
				case '0' :
					if(sum != 0) {
						return false;
					}
					break;
			}
		}

		return true;
	}

}