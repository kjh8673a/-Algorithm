import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String line = br.readLine();
            int len = line.length();

            int[] arr = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = (line.charAt(i) - '0' == 6 ? 9 : line.charAt(i) - '0');
            }
            Arrays.sort(arr);

            long a = 0;
            long b = 0;
            for (int i = len - 1; i >= 0; i--) {
                if (a >= b) {
                    b = b * 10 + arr[i];
                } else {
                    a = a * 10 + arr[i];
                }
            }

            sb.append(a * b + "\n");

        }

        System.out.println(sb);

    }

}