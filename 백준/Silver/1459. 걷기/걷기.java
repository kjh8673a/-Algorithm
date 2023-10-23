import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());
        long W = Integer.parseInt(st.nextToken());
        long S = Integer.parseInt(st.nextToken());

        long ans = Long.MAX_VALUE;

        // 평행 이동
        ans = Math.min(ans, (X + Y) * W);

        // 대각선 이용 최대로
        if ((X + Y) % 2 == 0) {
            ans = Math.min(ans, Math.max(X, Y) * S);
        } else {
            ans = Math.min(ans, (Math.max(X, Y) - 1) * S + W);
        }

        // 대각선 + 평행 이동
        ans = Math.min(ans, (Math.min(X, Y) * S) + Math.abs(X - Y) * W);

        System.out.println(ans);
    }

}
