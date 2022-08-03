import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int young = 0;
		int min = 0;

		int n = sc.nextInt();

		for(int i = 0; i < n; i++) {
			int a = sc.nextInt();

			if(a <= 29) {
				young += 10;
			}else {
				young += (a / 30 + 1) * 10;
			}

			if(a <= 19) {
				min += 15;
			}else {
				min += (a / 60 + 1) * 15;
			}
		}

		if(young < min) {
			System.out.println("Y " + young);
		}else if(min < young) {
			System.out.println("M " + min);
		}else {
			System.out.println("Y M " + young);
		}
		
		sc.close();
		
	}
	
}