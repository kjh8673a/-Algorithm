import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, NumberFormatException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            double ans = 0;
            for (int j = 0; j < k; j++) {
                ans = (ans + 0.5) * 2;
            }
            sb.append((int) ans).append("\n");
        }
        System.out.println(sb);
    }

}
