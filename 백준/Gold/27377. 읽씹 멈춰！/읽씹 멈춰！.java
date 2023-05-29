import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int tc = 0; tc < T; tc++) {
            long n = Long.parseLong(br.readLine());

            st = new StringTokenizer(br.readLine());
            BigInteger s = new BigInteger(st.nextToken());
            BigInteger t = new BigInteger(st.nextToken());

            BigInteger ans = BigInteger.ZERO;
            while (n > 0) {
                if (n % 2 == 1) {
                    n -= 1;
                    ans = ans.add(s);
                } else {
                    BigInteger num = new BigInteger(String.valueOf(n));
                    if (num.multiply(s).divide(BigInteger.TWO).compareTo(t) > 0) {
                        ans = ans.add(t);
                    } else {
                        ans = ans.add(s.multiply(num.divide(BigInteger.TWO)));
                    }
                    n /= 2;
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);

    }

}