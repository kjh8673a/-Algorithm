import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    static StringBuilder sb = new StringBuilder();

    static void hanoi(int n, int x, int y) {
        
        if (n > 1) {
            hanoi(n-1, x, 6-x-y);
        }
        sb.append(x + " " + y + "\n");
        if (n > 1) {
            hanoi(n-1, 6-x-y, y);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        sb.append((int)(Math.pow(2, n) - 1) + "\n");

        hanoi(n, 1, 3);

        System.out.println(sb.toString());
    }
}