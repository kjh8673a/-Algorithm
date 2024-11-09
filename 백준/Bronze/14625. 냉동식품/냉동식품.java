import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ha = Integer.parseInt(st.nextToken());
        int ma = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int hb = Integer.parseInt(st.nextToken());
        int mb = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        while (true) {
            if (ha % 10 == n || ha / 10 == n || ma % 10 == n || ma / 10 == n) {
                answer++;
            }

            if (ha == hb && ma == mb) {
                break;
            }

            ma++;
            if (ma == 60) {
                ha++;
                ma = 0;
            }
        }

        System.out.println(answer);
    }

}