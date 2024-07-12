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
            String n = st.nextToken();
            String m = st.nextToken();

            int zeroCount = 0;
            int oneCount = 0;
            for (int i = 0; i < n.length(); i++) {
                char nChar = n.charAt(i);
                char mChar = m.charAt(i);
                if (nChar != mChar) {
                    if (nChar == '0') {
                        zeroCount++;
                    } else {
                        oneCount++;
                    }
                }
            }

            sb.append(Math.max(zeroCount, oneCount)).append("\n");
        }

        System.out.println(sb);
    }

}