import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Integer.parseInt(st.nextToken());
        long k = Integer.parseInt(st.nextToken());

        // nCk
        long ans = factorial(n) / (factorial(k) * factorial(n-k));

        System.out.println(ans);

    }

    public static long factorial(long num) {
        if (num == 0 || num == 1) {
            return 1;
        } else {
            return factorial(num - 1) * num;
        }
    }

}