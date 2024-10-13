import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] head = new long[n];
        long[] tail = new long[n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            head[i] = Long.parseLong(st.nextToken());
            tail[i] = Long.parseLong(st.nextToken());
        }

        long tailLCM = tail[0];
        for (int i = 1; i < n; i++) {
            tailLCM = getLCM(tailLCM, tail[i]);
        }

        long headGCD = head[0] * (tailLCM / tail[0]);
        for (int i = 1; i < n; i++) {
            headGCD = getGCD(headGCD, head[i] * (tailLCM / tail[i]));
        }

        long gcd = getGCD(headGCD, tailLCM);

        System.out.println(headGCD / gcd + " " + tailLCM / gcd);
    }

    public static long getGCD(long num1, long num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1 % num2);
    }

    public static long getLCM(long num1, long num2) {
        return num1 * num2 / getGCD(num1, num2);
    }
}
