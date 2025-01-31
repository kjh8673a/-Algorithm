import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            String tmp = "";
            for (int i = 0; i < n; i++) {
                String s = st.nextToken();
                if (tmp.length() == 0) {
                    tmp = s;
                } else {
                    int now = s.charAt(0) - 'A';
                    int left = tmp.charAt(0) - 'A';

                    if (now <= left) {
                        tmp = s + tmp;
                    } else {
                        tmp += s;
                    }
                }
            }

            sb.append(tmp).append("\n");
        }

        System.out.println(sb.toString());
    }
}