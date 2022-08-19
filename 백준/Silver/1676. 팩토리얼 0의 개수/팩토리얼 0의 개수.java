import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Integer.parseInt(st.nextToken());

        long cnt5 = pow5(n);
        long cnt2 = pow2(n);

        System.out.println(Math.min(cnt5, cnt2));
    }

    public static long pow5(long num) {
        int cnt = 0;

        while (num >= 5) {
            cnt += (num / 5);
            num /= 5;
        }

        return cnt;
    }

    public static long pow2(long num) {
        int cnt = 0;

        while (num >= 2) {
            cnt += (num / 2);
            num /= 2;
        }

        return cnt;
    }

}