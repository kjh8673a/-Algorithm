import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static BigInteger[][] comb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        BigInteger k = BigInteger.valueOf(Integer.parseInt(st.nextToken()));

        comb = new BigInteger[n + m + 1][n + 1];

        BigInteger left = BigInteger.ONE;
        BigInteger right = combi(n + m, n);
        BigInteger mid = left.add((right.subtract(left).add(BigInteger.ONE)).multiply(BigInteger.valueOf(n))
                .divide(BigInteger.valueOf(n).add(BigInteger.valueOf(m))));
        // left + ((right - left + 1) * n / (n + m));

        if (combi(n + m, n).compareTo(k) == -1) {
            System.out.println(-1);
        } else {
            String ans = "";
            while (left.compareTo(right) == -1) { // left < right

                if (k.compareTo(mid) == -1) { // k < mid
                    ans += "a";
                    n--;
                    right = combi(n + m, n);
                    mid = left.add((right.subtract(left).add(BigInteger.ONE)).multiply(BigInteger.valueOf(n))
                            .divide(BigInteger.valueOf(n).add(BigInteger.valueOf(m))));
                } else {
                    ans += "z";
                    m--;
                    k = k.subtract(mid.subtract(BigInteger.ONE));
                    right = combi(n + m, n);
                    mid = left.add((right.subtract(left).add(BigInteger.ONE)).multiply(BigInteger.valueOf(n))
                            .divide(BigInteger.valueOf(n).add(BigInteger.valueOf(m))));
                }

            }

            for (int i = 0; i < n; i++) {
                ans += "a";
            }
            for (int i = 0; i < m; i++) {
                ans += "z";
            }

            System.out.println(ans);
        }
    }

    public static BigInteger combi(int n, int r) {
        if (comb[n][r] != null) {
            return comb[n][r];
        }
        if (n == r || r == 0) {
            return BigInteger.ONE;
        } else {
            comb[n][r] = combi(n - 1, r - 1).add(combi(n - 1, r));
            return comb[n][r];
        }
    }

}