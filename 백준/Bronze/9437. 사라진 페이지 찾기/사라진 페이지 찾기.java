import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }

            int p = Integer.parseInt(st.nextToken());
            if (p <= n / 2) {
                if (p % 2 == 0) {
                    sb.append(p - 1).append(" ");
                    sb.append((n + 1) - p).append(" ");
                    sb.append((n + 1) - (p - 1)).append("\n");
                } else {
                    sb.append(p + 1).append(" ");
                    sb.append((n + 1) - (p + 1)).append("\n");
                    sb.append((n + 1) - p).append(" ");
                }
            } else {
                if (p % 2 == 0) {
                    sb.append((n + 1) - p).append(" ");
                    sb.append((n + 1) - (p - 1)).append(" ");
                    sb.append(p - 1).append("\n");
                } else {
                    sb.append((n + 1) - (p + 1)).append(" ");
                    sb.append((n + 1) - p).append(" ");
                    sb.append(p + 1).append("\n");
                }
            }
        }

        System.out.println(sb.toString());
    }
}