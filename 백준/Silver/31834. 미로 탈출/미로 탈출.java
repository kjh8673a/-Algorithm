import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if ((s == n && e == 1) || (s == 1 && e == n)) {
                sb.append(0);
            } else if (s == 1 || s == n || Math.abs(s - e) == 1) {
                sb.append(1);
            } else {
                sb.append(2);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

}