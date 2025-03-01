import java.io.*;
import java.util.*;

public class Main {
    static int lose;
    static boolean[] base;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            String token = st.nextToken();

            String tmp = "";
            for (int i = 0; i < token.length(); i++) {
                if (token.charAt(i) == '<' || token.charAt(i) == '>' || token.charAt(i) == '('
                        || token.charAt(i) == ')') {
                    if (tmp.length() > 0) {
                        sb.append(tmp).append(" ");
                        tmp = "";
                    }
                    sb.append(token.charAt(i)).append(" ");
                } else if (token.charAt(i) == '&' && i < token.length() - 1 && token.charAt(i + 1) == '&') {
                    if (tmp.length() > 0) {
                        sb.append(tmp).append(" ");
                        tmp = "";
                    }
                    sb.append("&&").append(" ");
                    i++;
                } else if (token.charAt(i) == '|' && i < token.length() - 1 && token.charAt(i + 1) == '|') {
                    if (tmp.length() > 0) {
                        sb.append(tmp).append(" ");
                        tmp = "";
                    }
                    sb.append("||").append(" ");
                    i++;
                } else {
                    tmp += token.charAt(i);
                }
            }

            if (tmp.length() > 0) {
                sb.append(tmp).append(" ");
            }
        }

        System.out.println(sb.toString());
    }

}