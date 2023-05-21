import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long[][] arr = { { 1, 1 }, { 1, 0 } };
        long[][] ans = pow(arr, N - 1);
        System.out.println(ans[0][0]);

    }

    private static long[][] pow(long[][] arr, long n) {
        if (n == 1 || n == 0) {
            return arr;
        }

        long[][] tmp = pow(arr, n / 2);
        if (n % 2 == 0) {
            tmp = multiply(tmp, tmp);
        } else {
            tmp = multiply(multiply(tmp, tmp), arr);
        }

        return tmp;
    }

    private static long[][] multiply(long[][] a, long[][] b) {
        long[][] tmp = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    tmp[i][j] += (a[i][k] * b[k][j]) % MOD;
                }
                tmp[i][j] %= MOD;
            }
        }

        return tmp;
    }

}