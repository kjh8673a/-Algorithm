import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double w = Double.parseDouble(st.nextToken());
        double h = Double.parseDouble(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        double answer = 0;
        for (int i = 1; i < n; i++) {
            double nw = Math.min(w / n * i, w - w / n * i);
            double nh = h * nw / (w / 2);
            answer += (h - nh);
        }

        System.out.println(String.format("%.6f", answer));
    }

}
