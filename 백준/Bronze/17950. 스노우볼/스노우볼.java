import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        long answer = 0;
        long mul = 1;
        for(int i = 1; i < h + 1; i++) {
            int c = Integer.parseInt(br.readLine());
            mul *= x;
            mul %= MOD;

            answer += c * mul;
            answer %= MOD;
        }

        System.out.println(answer);
    }

}
