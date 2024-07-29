import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 0; tc < n; tc++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int gcd = getGCD(Math.max(a, b), Math.min(a, b));

            sb.append(a / gcd).append(" ").append(b / gcd).append("\n");
        }

        System.out.println(sb);
    }

    private static int getGCD(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return getGCD(b, a % b);
    }

}