import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine() + " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        int ans;
        st = new StringTokenizer(br.readLine());
        for (int tc = 0; tc < n; tc++) {
            BigInteger num = new BigInteger(st.nextToken());

            BigInteger sq = sqrt(num);

            if(sq.multiply(sq).equals(num)) {
                ans = 1;
            }else {
                ans = 0;
            }

            sb.append(ans + " ");

        }

        System.out.println(sb.toString());

    }


    public static BigInteger sqrt(BigInteger num) {
        BigInteger div = BigInteger.ZERO.setBit(num.bitLength()/2);
        BigInteger div2 = div;
        while(true) {
            BigInteger tmp = div.add(num.divide(div)).shiftRight(1);
            if(tmp.equals(div) || tmp.equals(div2)) {
                return tmp;
            }
            div2 = div;
            div = tmp;
        }
    }

}
