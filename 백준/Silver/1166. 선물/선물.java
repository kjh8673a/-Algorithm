import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        double left = 0;
        double right = Math.min(l, Math.min(w, h));

        for (int i = 0; i < 10000; i++) {
            double mid = (left + right) / 2;
            if ((long) (l / mid) * (long) (w / mid) * (long) (h / mid) < n) {
                right = mid;
            } else {
                left = mid;
            }
        }

        System.out.println(left);
    }

}