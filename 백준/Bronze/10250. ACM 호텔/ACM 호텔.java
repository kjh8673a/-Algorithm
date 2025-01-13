import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int roomNumber = n / h;
            if (n % h > 0) {
                roomNumber++;
            }

            int floor = h;
            if (n % h > 0) {
                floor = n % h;
            }

            sb.append(floor + String.format("%02d", roomNumber)).append("\n");
        }

        System.out.println(sb.toString());
    }

}