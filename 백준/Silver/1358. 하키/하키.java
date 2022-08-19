import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double w = Integer.parseInt(st.nextToken());
        double h = Integer.parseInt(st.nextToken());
        double x = Integer.parseInt(st.nextToken());
        double y = Integer.parseInt(st.nextToken());
        double p = Integer.parseInt(st.nextToken());

        double center1X = x;
        double center1Y = y + h / 2;

        double center2X = x + w;
        double center2Y = y + h / 2;

        double r = h / 2;

        int cnt = 0;
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            double a = Integer.parseInt(st.nextToken());
            double b = Integer.parseInt(st.nextToken());

            if (a >= x && a <= x + w && b >= y && b <= y + h) {
                cnt++;
            } else if (Math.pow(center1X - a, 2) + Math.pow(center1Y - b, 2) <= Math.pow(r, 2)) {
                cnt++;
            } else if (Math.pow(center2X - a, 2) + Math.pow(center2Y - b, 2) <= Math.pow(r, 2)) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }

}