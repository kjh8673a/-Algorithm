import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[][] arr = new int[n][5];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 5; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int[][] ans = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < 5; j++) {
				for(int k = 0; k < n; k++) {
					if(arr[i][j] == arr[k][j] && i != k) {
						ans[i][k]++;
					}
				}
			}
		}

		int[] fin = new int[n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(ans[i][j] != 0) {
					fin[i]++;
				}
			}
		}


		int max = 0;
		for(int i = 0; i < n; i++) {
			if(fin[i] >= max) max = fin[i];
		}

		for(int i = 0; i < n; i++) {
			if(fin[i] == max) {
				System.out.println(i+1);
				break;
			}
		}

		sc.close();

	}
}
