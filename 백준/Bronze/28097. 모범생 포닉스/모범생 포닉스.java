import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sum += Integer.parseInt(st.nextToken());
        }
        sum += 8 * (n - 1);

        int day = sum / 24;
        int hour = sum % 24;

        System.out.println(day + " " + hour);
    }

}