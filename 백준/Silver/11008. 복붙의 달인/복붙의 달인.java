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
            String s = st.nextToken();
            String p = st.nextToken();

            int answer = 0;
            while (s.contains(p)) {
                s = s.replaceFirst(p, "");
                answer++;
            }

            answer += s.length();

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}