import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());

            long d1 = 1l * (a + b) * (a + b) + 1l * c * c;
            long d2 = 1l * (b + c) * (b + c) + 1l * a * a;
            long d3 = 1l * (c + a) * (c + a) + 1l * b * b;

            long ans = Math.min(d1, d2);
            ans = Math.min(ans, d3);

            sb.append(ans).append("\n");
        }

        System.out.println(sb.toString());

    }

}