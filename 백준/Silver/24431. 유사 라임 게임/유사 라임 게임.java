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
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int f = Integer.parseInt(st.nextToken());

            int count = 0;
            Set<String> set = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                String w = st.nextToken();
                String tail = w.substring(l - f);

                if (set.contains(tail)) {
                    count++;
                    set.remove(tail);
                } else {
                    set.add(tail);
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb.toString());
    }

}