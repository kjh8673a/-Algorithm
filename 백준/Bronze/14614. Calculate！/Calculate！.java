import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        BigInteger C = new BigInteger(st.nextToken());
        if (C.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            System.out.println(A);
        } else {
            System.out.println(A ^ B);
        }
    }
}