import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());

            int half = t / 2;
            String ans = "WOO";
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < t; j++) {
                String num = st.nextToken();
                if (ans == "WOO") {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                    if (map.get(num) > half) {
                        ans = num;
                        sb.append(ans).append("\n");
                    }
                }
            }
            if (ans == "WOO") {
                sb.append("SYJKGW").append("\n");
            }

        }

        System.out.println(sb.toString());

    }

}