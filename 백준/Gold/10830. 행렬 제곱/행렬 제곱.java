import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    final static long MOD = 1000;
    static int N;
    static long[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        matrix = new long[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Long.parseLong(st.nextToken()) % MOD;
            }
        }

        long[][] result = doPow(matrix, B);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                long now = result[i][j] % MOD;
                sb.append(now + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static long[][] doPow(long[][] arr, long n) {
        if (n == 1) {
            return arr;
        }

        long[][] tmp = doPow(arr, n / 2);
        if (n % 2 == 0) {
            tmp = multiply(tmp, tmp);
        } else {
            tmp = multiply(multiply(tmp, tmp), arr);
        }

        return tmp;
    }

    public static long[][] multiply(long[][] a, long[][] b) {
        long[][] tmp = new long[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                for (int k = 0; k < N; k++) {
                    tmp[i][j] += (a[i][k] * b[k][j]) % MOD;
                }
                tmp[i][j] %= MOD;

            }
        }

        return tmp;
    }

}