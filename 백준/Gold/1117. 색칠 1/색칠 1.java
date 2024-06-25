import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long W = Long.parseLong(st.nextToken());
        long H = Long.parseLong(st.nextToken());
        long f = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long x1 = Long.parseLong(st.nextToken());
        long y1 = Long.parseLong(st.nextToken());
        long x2 = Long.parseLong(st.nextToken());
        long y2 = Long.parseLong(st.nextToken());

        long answer = W * H;

        long w = f <= W / 2 ? f : W - f;
        answer -= (Math.max(0, Math.min(w - x1, x2 - x1)) * (y2 - y1) * (c + 1) * 2);
        answer -= (Math.max(0, Math.min(x2 - x1, x2 - w)) * (y2 - y1) * (c + 1));

        System.out.println(answer);
    }
}