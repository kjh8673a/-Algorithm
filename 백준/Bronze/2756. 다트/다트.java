import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i = 0; i < t; i++) {
			int n = 0;
			int m = 0;
			for(int j = 0; j < 6; j++) {
				double x = sc.nextDouble();
				double y = sc.nextDouble();
				double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
				if(j < 3) {
					if(distance <= 3) {
						n += 100;
					}else if(distance <= 6) {
						n += 80;
					}else if(distance <= 9) {
						n += 60;
					}else if(distance <= 12) {
						n += 40;
					}else if(distance <= 15) {
						n += 20;
					}
				}else {
					if(distance <= 3) {
						m += 100;
					}else if(distance <= 6) {
						m += 80;
					}else if(distance <= 9) {
						m += 60;
					}else if(distance <= 12) {
						m += 40;
					}else if(distance <= 15) {
						m += 20;
					}
				}
			}
			System.out.print("SCORE: " + n + " to " + m + ", ");
			if(n > m) {
				System.out.println("PLAYER 1 WINS.");
			}else if(n < m) {
				System.out.println("PLAYER 2 WINS.");
			}else {
				System.out.println("TIE.");
			}
		}
		sc.close();
	}
}