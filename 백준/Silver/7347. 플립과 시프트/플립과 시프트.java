import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int len = Integer.parseInt(st.nextToken());
            int odd = 0;
            int even = 0;
            for (int i = 0; i < len; i++) {
                int color = Integer.parseInt(st.nextToken());
                if (color == 1) {
                    if (i % 2 == 0) {
                        even++;
                    } else {
                        odd++;
                    }
                }
            }

            if (len % 2 == 1) {
                sb.append("YES").append("\n");
            } else {
                if (Math.abs(even - odd) <= 1) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }
        }

        System.out.println(sb);
    }

}