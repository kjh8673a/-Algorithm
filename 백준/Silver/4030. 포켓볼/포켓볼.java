import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = 1;
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0) {
                break;
            }

            int answer = 0;
            int x = 2;
            while (true) {
                int triangle = x * (x + 1) / 2;
                if (triangle + 1 > a && triangle + 1 < b) {
                    if (Math.sqrt(triangle + 1) % 1 == 0) {
                        answer++;
                    }
                }
                if (triangle + 1 >= b) {
                    break;
                }
                x++;
            }

            sb.append("Case " + tc++ + ": " + answer).append("\n");
        }

        System.out.println(sb);
    }

}