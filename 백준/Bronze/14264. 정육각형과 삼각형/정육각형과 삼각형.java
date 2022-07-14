import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double l = sc.nextDouble();
		
		double a = Math.sqrt((l*l - (l/2)*(l/2)));
		
		System.out.println(a * l / 2);
		
		sc.close();
	}
}
