import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int tc = 0; tc < 3; tc++) {
            int N = Integer.parseInt(br.readLine());
            BigInteger sum = BigInteger.ZERO;
            for(int i = 0; i < N; i++) {
                sum = sum.add(new BigInteger(br.readLine()));
            }
            int compare = sum.compareTo(BigInteger.ZERO);
            if(compare == 0) {
                sb.append("0").append("\n");
            }else if(compare == 1) {
                sb.append("+").append("\n");
            }else {
                sb.append("-").append("\n");
            }
        }
        System.out.println(sb);
    }
}
