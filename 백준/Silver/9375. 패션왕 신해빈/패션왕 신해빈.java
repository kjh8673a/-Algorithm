import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());

            Map<String, Integer> map = new HashMap<>();
            StringTokenizer st;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String part = st.nextToken();
                map.put(part, map.getOrDefault(part, 1) + 1);
            }

            int ans = 1;
            for (String key : map.keySet()) {
                ans *= map.get(key);
            }
            ans -= 1;

            sb.append(ans + "\n");

        }

        System.out.println(sb);

    }

}