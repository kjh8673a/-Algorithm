import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long Sx = 0;
        long Sy = 0;
        long Sxx = 0;
        long Sxy = 0;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            Sx += x;
            Sy += y;
            Sxx += (x * x);
            Sxy += (x * y);
        }

        if (Sx * Sx != n * Sxx) {
            double a = (double) (n * Sxy - Sx * Sy) / (n * Sxx - Sx * Sx);
            double b = (double) (Sy - a * Sx) / n;

            System.out.println(a + " " + b);
        } else {
            System.out.println("EZPZ");
        }

    }

}