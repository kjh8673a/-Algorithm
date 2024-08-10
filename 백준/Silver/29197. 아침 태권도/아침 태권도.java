import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a != 0 && b != 0) {
                int gcd = getGCD(a, b);
                set.add(a / gcd + "::" + b / gcd);
            } else if (a == 0) {
                set.add(0 + "::" + b / Math.abs(b));
            } else {
                set.add(a / Math.abs(a) + "::" + 0);
            }
        }

        System.out.println(set.size());
    }

    private static int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1 % num2);
    }

}