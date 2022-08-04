import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double d = sc.nextDouble();
		double h = sc.nextDouble();
		double w = sc.nextDouble();				
		sc.close();
		
		System.out.println((int)Math.sqrt(d*d*(h*h)/(h*h+w*w)) + " " + (int)Math.sqrt(d*d*(w*w)/(h*h+w*w)));
		
	}
}