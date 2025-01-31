import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        long pa = Long.parseLong(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        long pb = Long.parseLong(st.nextToken());

        long power = 0;
        long tanker = 0;
        long dealer = 0;
        for (int i = 0; i * pa <= n; i++) {
            long ta = i;
            long tb = (n - i * pa) / pb;
            long tmp = a * ta + b * tb;
            if (tmp > power && ta * pa + tb * pb <= n) {
                power = tmp;
                tanker = ta;
                dealer = tb;
            }
        }

        System.out.println(tanker + " " + dealer);
    }

}