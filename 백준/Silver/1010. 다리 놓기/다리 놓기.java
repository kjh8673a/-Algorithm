import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            // 팩토리얼을 계산해야 되므로 값이 엄청나게 커질거 대비하여 BigInteger
            BigInteger n = new BigInteger(st.nextToken());
            BigInteger m = new BigInteger(st.nextToken());
            
            // n <= m 이므로 오른쪽 m개중에 n개를 선택해서 놓인 순서대로 왼쪽과 연결하면 끝
            // nCr = n!/n!(n-r)!
            BigInteger mFac = factorial(m);
            BigInteger nFac = factorial(n);
            BigInteger minusFac = factorial(m.subtract(n));

            sb.append(mFac.divide(nFac.multiply(minusFac))).append("\n");
        }

        System.out.println(sb.toString());
    }

    // 팩토리얼 계산
    private static BigInteger factorial(BigInteger num) {
        BigInteger one = new BigInteger("1");
        if(num.intValue() == 0 || num.intValue() == 1) {
            return one;
        }else{
            return factorial(num.subtract(one)).multiply(num);
        }
    }
}