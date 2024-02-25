import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            BigInteger k = new BigInteger(br.readLine());
            if (k.remainder(BigInteger.TWO).equals(BigInteger.ZERO)) {
                sb.append("even").append("\n");
            } else {
                sb.append("odd").append("\n");
            }
        }

        System.out.println(sb);
    }

}