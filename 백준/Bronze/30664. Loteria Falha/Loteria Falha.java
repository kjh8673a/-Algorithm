import java.io.*;
import java.math.BigInteger;

public class Main {
    static final BigInteger MOD = BigInteger.valueOf(42);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("0")) {
                break;
            }

            BigInteger num = new BigInteger(input);
            if (num.remainder(MOD).compareTo(BigInteger.ZERO) == 0) {
                sb.append("PREMIADO").append("\n");
            } else {
                sb.append("TENTE NOVAMENTE").append("\n");
            }
        }

        System.out.println(sb);
    }

}