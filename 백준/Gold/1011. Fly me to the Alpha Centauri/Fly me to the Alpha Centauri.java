import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int dist = y - x;

            int sqrt = (int) Math.sqrt(dist);

            if (sqrt * sqrt == dist) {
                sb.append(2 * sqrt - 1).append("\n");
            } else if (dist <= sqrt * sqrt + sqrt) {
                sb.append(2 * sqrt).append("\n");
            } else {
                sb.append(2 * sqrt + 1).append("\n");
            }
        }

        System.out.println(sb);
    }

}