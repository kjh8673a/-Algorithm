import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, List<String>> map = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String ring = st.nextToken();
            if (ring.equals("-")) {
                continue;
            }

            map.computeIfAbsent(ring, k -> new ArrayList<>()).add(name);
        }

        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getValue().size() == 2) {
                answer++;
                for (String name : entry.getValue()) {
                    sb.append(name).append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.println(answer);
        System.out.println(sb);
    }

}