import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        int start = Integer.parseInt(s.split(":")[0]) * 60 + Integer.parseInt(s.split(":")[1]);
        String e = st.nextToken();
        int end = Integer.parseInt(e.split(":")[0]) * 60 + Integer.parseInt(e.split(":")[1]);
        String q = st.nextToken();
        int quit = Integer.parseInt(q.split(":")[0]) * 60 + Integer.parseInt(q.split(":")[1]);

        Set<String> enter = new HashSet<>();
        Set<String> out = new HashSet<>();
        String input = "";
        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input, " ");
            String t = st.nextToken();
            int time = Integer.parseInt(t.split(":")[0]) * 60 + Integer.parseInt(t.split(":")[1]);
            String name = st.nextToken();
            if (time <= start) {
                enter.add(name);
            } else if (time >= end && time <= quit) {
                out.add(name);
            }
        }

        int ans = 0;
        for (String val : enter) {
            if (out.contains(val)) {
                ans++;
            }
        }

        System.out.println(ans);
    }

}