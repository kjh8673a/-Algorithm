import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int minOdd = Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            sum += a;
            if (a % 2 != 0) {
                minOdd = Math.min(a, minOdd);
            }
        }

        if (sum % 2 != 0) {
            sum -= minOdd;
        }

        System.out.println(sum);
    }

}