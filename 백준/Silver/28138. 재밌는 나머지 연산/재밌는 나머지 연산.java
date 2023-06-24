import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long R = Long.parseLong(st.nextToken());

        long num = N - R;
        long ans = 0;
        for (long i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                if (N % i == R) {
                    ans += i;
                }
                if (num / i != i) {
                    if (N % (num / i) == R) {
                        ans += (num / i);
                    }
                }
            }
        }

        System.out.println(ans);
    }

}
