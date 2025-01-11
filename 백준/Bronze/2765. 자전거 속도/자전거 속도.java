import java.io.*;
import java.util.*;

public class Main {
    static final double pie = 3.1415927;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int idx = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            double c = Double.parseDouble(st.nextToken());
            if (b == 0) {
                break;
            }

            sb.append("Trip #" + idx + ": ");

            double distance = a * pie * b / 12 / 5280;
            sb.append(String.format("%.2f", distance) + " ");

            double MPH = distance / (c / 3600);
            sb.append(String.format("%.2f", MPH)).append("\n");

            idx++;
        }

        System.out.println(sb.toString());
    }
}