import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int idx = 1;
        while(true) {
        	int r = sc.nextInt();
        	if(r == 0) break;
        	int w = sc.nextInt();
        	int l = sc.nextInt();
        	
        	if((2*r)*(2*r) >= w*w + l*l) {
        		System.out.println("Pizza " + idx + " fits on the table.");
        	}else {
        		System.out.println("Pizza " + idx + " does not fit on the table.");
        	}
        	
        	idx++;
        }
        
        sc.close();
    }
}