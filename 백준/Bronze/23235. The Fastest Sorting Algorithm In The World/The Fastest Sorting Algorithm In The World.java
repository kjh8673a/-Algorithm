import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int idx = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }
            for (int i = 0; i < n; i++) {
                int a = Integer.parseInt(st.nextToken());
            }

            sb.append("Case " + idx + ": Sorting... done!").append("\n");
            idx++;
        }

        System.out.println(sb);
    }

}