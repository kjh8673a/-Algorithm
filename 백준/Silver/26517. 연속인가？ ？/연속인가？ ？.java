import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = cal(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), k);
        long B = cal(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), k);
        if (A == B) {
            System.out.println("Yes " + A);
        } else {
            System.out.println("No");
        }
    }

    public static long cal(long a, long b, long k) {
        return a * k + b;
    }

}