import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[14];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 14; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int bnpMoney = n;
		int bnpStock = 0;

		int timingMoney = n;
		int timingStock = 0;

		// 1: 증가, 0: 그대로, -1: 감소
		int type = 0;
		int strick = 0;

		for(int i = 0; i < 14; i++) {
			
			
			// BNP
			if(bnpMoney >= arr[i]) {
				bnpStock += bnpMoney / arr[i];
				bnpMoney %= arr[i];
			}

			// TIMING
			if(type == 1 && strick >= 3) {
				timingMoney += timingStock * arr[i];
				timingStock = 0;
			}
			if(i > 0 && arr[i] > arr[i-1]) {
				if(type != 1) {
					type = 1;
					strick = 2;
				}else {
					strick++;
				}
			}

			if(type == -1 && strick >= 3) {
				timingStock += timingMoney / arr[i];
				timingMoney %= arr[i];
			}
			if(i > 0 && arr[i] < arr[i-1]) {
				if(type != -1) {
					type = -1;
					strick = 2;
				}else {
					strick++;
				}
			}

			if(i > 0 && arr[i] == arr[i-1]) {
				type = 0;
				strick = 0;
			}
		}

		int bnpTotal = bnpMoney + bnpStock * arr[13];
		int timingTotal = timingMoney + timingStock * arr[13];

		if(bnpTotal > timingTotal) {
			System.out.println("BNP");
		}else if(bnpTotal < timingTotal) {
			System.out.println("TIMING");
		}else {
			System.out.println("SAMESAME");
		}

	}

}
