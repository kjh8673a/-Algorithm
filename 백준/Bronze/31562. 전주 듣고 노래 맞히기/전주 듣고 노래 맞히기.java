import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String title = st.nextToken();

            String note = "";
            while (st.hasMoreTokens()) {
                note += st.nextToken();
            }

            map.put(title, note);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String b = br.readLine().replace(" ", "");
            int count = 0;
            String title = "";
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String note = entry.getValue();
                if (note.startsWith(b)) {
                    count++;
                    title = entry.getKey();
                }
            }

            if (count == 0) {
                sb.append("!").append("\n");
            } else if (count > 1) {
                sb.append("?").append("\n");
            } else {
                sb.append(title).append("\n");
            }
        }

        System.out.println(sb);
    }

}