import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long answer = pow(m, n) - pow(m - 1, n);
        System.out.println(answer < 0 ? answer + MOD : answer);
    }

    private static long pow(long m, int n) {
        long result = 1;

        while (n-- > 0) {
            result *= m;
            result %= MOD;
        }

        return result;
    }

}