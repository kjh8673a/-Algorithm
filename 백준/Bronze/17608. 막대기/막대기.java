import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for(int i = 0; i < n; i++) {
        	height[i] = sc.nextInt();
        }
        sc.close();
        int max = height[n-1];
        int cnt = 1;
        for(int i = n-1; i >= 0; i--) {
        	if(max < height[i]) {
        		cnt++;
        		max = height[i];
        	}
        }
        System.out.println(cnt);
    }
}