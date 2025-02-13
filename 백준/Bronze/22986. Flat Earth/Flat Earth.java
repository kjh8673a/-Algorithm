import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());

            if (n - k < 0) {
                k = n;
            }
            long answer = (n + n - k) * (n - (n - k) + 1) / 2 * 4;

            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }

}