import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a + b == 0) {
                break;
            }
            sb.append(Integer.compare(a, b) == 1 ? "Yes" : "No").append("\n");
        }
        System.out.println(sb);
    }

}
